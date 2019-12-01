package org.tank.core.swagger.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

/**
  * @description swagger配置
  * @author lbx
  * @date 2019/12/1 9:58
  * @version 1.0.0
 **/
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
public class SwaggerAutoConfiguration implements BeanFactoryAware {

    /**默认路径*/
    private static final String BASE_PATH = "/**";

    private BeanFactory beanFactory;

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties() {
        return new SwaggerProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
    public List<Docket> createRestApi(SwaggerProperties swaggerProperties) {
        ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
        List<Docket> docketList = new LinkedList<>();
        // 没有分组
        if (swaggerProperties.getDocket().size() == 0) {
            final Docket docket = createDocket(swaggerProperties);
            configurableBeanFactory.registerSingleton("defaultDocket", docket);
            docketList.add(docket);
            return docketList;
        }
        //todo 分组创建
        for (String groupName : swaggerProperties.getDocket().keySet()) {

        }
        return docketList;
    }

    /**
      * 创建Docket对象
      * @param  swaggerProperties
      * @return springfox.documentation.spring.web.plugins.Docket
      * @author lbx
      * @date 2019/12/1 10:17
      * @version 1.0.0
     **/
    private Docket createDocket(final SwaggerProperties swaggerProperties) {
        ApiInfo apiInfo = apiInfo(swaggerProperties);
        // 当没有配置任何path的时候，解析/**
        if (swaggerProperties.getBasePath().isEmpty()) {
            swaggerProperties.getBasePath().add(BASE_PATH);
        }
        List<Predicate<String>> basePath = new ArrayList<>();
        for (String path : swaggerProperties.getBasePath()) {
            basePath.add(PathSelectors.ant(path));
        }
        // exclude-path处理
        List<Predicate<String>> excludePath = new ArrayList<>();
        for (String path : swaggerProperties.getExcludePath()) {
            excludePath.add(PathSelectors.ant(path));
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerProperties.getHost())
                .apiInfo(apiInfo)
                .globalOperationParameters(buildGlobalOperationParametersFromSwaggerProperties(
                        swaggerProperties.getGlobalOperationParameters()))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(
                        Predicates.and(
                                Predicates.not(Predicates.or(excludePath)),
                                Predicates.or(basePath)
                        )
                )
                .build()
                .securitySchemes(Collections.singletonList(securitySchema()))
                .securityContexts(Collections.singletonList(securityContext()))
                .pathMapping("/");


    }
    /**
      * 接口文档信息
      * @param  swaggerProperties
      * @return springfox.documentation.service.ApiInfo
      * @author lbx
      * @date 2019/12/1 10:15
      * @version 1.0.0
     **/
    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .license(swaggerProperties.getLicense())
                .licenseUrl(swaggerProperties.getLicenseUrl())
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }

    /**
      * 创建全局配置参数
      * @param  globalOperationParameters
      * @return java.util.List<springfox.documentation.service.Parameter>
      * @author lbx
      * @date 2019/12/1 10:22
      * @version 1.0.0
     **/
    private List<Parameter> buildGlobalOperationParametersFromSwaggerProperties(
            List<SwaggerProperties.GlobalOperationParameter> globalOperationParameters) {
        List<Parameter> parameters = Lists.newArrayList();

        if (Objects.isNull(globalOperationParameters)) {
            return parameters;
        }
        for (SwaggerProperties.GlobalOperationParameter globalOperationParameter : globalOperationParameters) {
            parameters.add(new ParameterBuilder()
                    .name(globalOperationParameter.getName())
                    .description(globalOperationParameter.getDescription())
                    .modelRef(new ModelRef(globalOperationParameter.getModelRef()))
                    .parameterType(globalOperationParameter.getParameterType())
                    .required(Boolean.parseBoolean(globalOperationParameter.getRequired()))
                    .build());
        }
        return parameters;
    }

    /**
      * 配置默认的全局鉴权策略的开关，通过正则表达式进行匹配；默认匹配所有URL
      * @return springfox.documentation.spi.service.contexts.SecurityContext
      * @author lbx
      * @date 2019/12/1 10:24
      * @version 1.0.0
     **/
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(swaggerProperties().getAuthorization().getAuthRegex()))
                .build();
    }

    /**
     * 配置默认的全局鉴权
     *
     * @return
     */
    private OAuth securitySchema() {
        ArrayList<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        swaggerProperties().getAuthorization().getAuthorizationScopeList().forEach(authorizationScope -> authorizationScopeList.add(new AuthorizationScope(authorizationScope.getScope(), authorizationScope.getDescription())));
        ArrayList<GrantType> grantTypes = new ArrayList<>();
        swaggerProperties().getAuthorization().getTokenUrlList().forEach(tokenUrl -> grantTypes.add(new ResourceOwnerPasswordCredentialsGrant(tokenUrl)));
        return new OAuth(swaggerProperties().getAuthorization().getName(), authorizationScopeList, grantTypes);
    }

    /**
     * 默认的全局鉴权策略
     *
     * @return
     */
    private List<SecurityReference> defaultAuth() {
        ArrayList<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        swaggerProperties().getAuthorization().getAuthorizationScopeList().forEach(authorizationScope -> authorizationScopeList.add(new AuthorizationScope(authorizationScope.getScope(), authorizationScope.getDescription())));
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[authorizationScopeList.size()];
        return Collections.singletonList(SecurityReference.builder()
                .reference(swaggerProperties().getAuthorization().getName())
                .scopes(authorizationScopeList.toArray(authorizationScopes))
                .build());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}

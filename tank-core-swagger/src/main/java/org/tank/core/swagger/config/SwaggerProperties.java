package org.tank.core.swagger.config;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lbx
 * @version 1.0.0
 * @description swagger2 属性配置
 * @date 2019/12/1 10:02
 **/
@Data
@ConfigurationProperties("swagger")
public class SwaggerProperties {

    /**
     * 是否开启swagger
     **/
    private Boolean enabled;
    /**
     * 标题
     **/
    private String title = "";
    /**
     * 描述
     **/
    private String description = "";
    /**
     * 版本
     **/
    private String version = "";
    /**
     * 许可证
     **/
    private String license = "";
    /**
     * 许可证URL
     **/
    private String licenseUrl = "";
    /**
     * 服务条款URL
     **/
    private String termsOfServiceUrl = "";
    /**
     * 联系人
     **/
    private Contact contact = new Contact();

    /**
     * swagger会解析的包路径
     **/
    private String basePackage = "";

    /**
     * swagger会解析的url规则
     **/
    private List<String> basePath = new ArrayList<>();
    /**
     * 在basePath基础上需要排除的url规则
     **/
    private List<String> excludePath = new ArrayList<>();

    /**
     * 分组文档
     **/
    private Map<String, DocketInfo> docket = new LinkedHashMap<>();

    /**
     * host信息
     **/
    private String host = "";

    /**
     * 全局参数配置
     **/
    private List<GlobalOperationParameter> globalOperationParameters;

    /**
     * 全局统一鉴权配置
     **/
    private Authorization authorization = new Authorization();

    @Setter
    @Getter
    public static class GlobalOperationParameter {
        /**
         * 参数名
         **/
        private String name;

        /**
         * 描述信息
         **/
        private String description;

        /**
         * 指定参数类型
         **/
        private String modelRef;

        /**
         * 参数放在哪个地方:header,query,path,body.form
         **/
        private String parameterType;

        /**
         * 参数是否必须传
         **/
        private String required;
    }

    @Data
    public static class DocketInfo {
        /**
         * 标题
         **/
        private String title = "";
        /**
         * 描述
         **/
        private String description = "";
        /**
         * 版本
         **/
        private String version = "";
        /**
         * 许可证
         **/
        private String license = "";
        /**
         * 许可证URL
         **/
        private String licenseUrl = "";
        /**
         * 服务条款URL
         **/
        private String termsOfServiceUrl = "";

        private Contact contact = new Contact();

        /**
         * swagger会解析的包路径
         **/
        private String basePackage = "";

        /**
         * swagger会解析的url规则
         **/
        private List<String> basePath = new ArrayList<>();
        /**
         * 在basePath基础上需要排除的url规则
         **/
        private List<String> excludePath = new ArrayList<>();

        private List<GlobalOperationParameter> globalOperationParameters;
    }

    @Data
    public static class Contact {
        /**
         * 联系人
         **/
        private String name = "";
        /**
         * 联系人url
         **/
        private String url = "";
        /**
         * 联系人email
         **/
        private String email = "";
    }


    @Data
    @NoArgsConstructor
    public static class Authorization {

        /**
         * 鉴权策略ID，需要和SecurityReferences ID保持一致
         */
        private String name = "";

        /**
         * 需要开启鉴权URL的正则
         */
        private String authRegex = "^.*$";

        /**
         * 鉴权作用域列表
         */
        private List<AuthorizationScope> authorizationScopeList = new ArrayList<>();

        private List<String> tokenUrlList = new ArrayList<>();
    }

    @Data
    @NoArgsConstructor
    public static class AuthorizationScope {

        /**
         * 作用域名称
         */
        private String scope = "";

        /**
         * 作用域描述
         */
        private String description = "";

    }

}

package org.tank.core.db.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.PostgreSqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.tank.core.tool.utils.StringUtil;

import java.io.IOException;
import java.util.*;

/**
  * @description 代码生成工具类
  * @author lbx
  * @date 2019/12/1 14:39
  * @version 1.0.0
 **/
@Data
@Slf4j
public class CodeGenerator {

    /**
     * 代码模块名称
     */
    private String codeName;
    /**
     * 代码所在服务名
     */
    private String serviceName = "tank-service";
    /**
     * 代码生成的包名
     */
    private String packageName = "org.tank.test";
    /**
     * 代码后端生成的地址
     */
    private String packageDir;
    /**
     * 代码前端生成的地址
     */
    private String packageWebDir;
    /**
     * 需要去掉的表前缀
     */
    private String[] tablePrefix = {"sys_"};
    /**
     * 需要生成的表名(两者只能取其一)
     */
    private String[] includeTables = {};
    /**
     * 需要排除的表名(两者只能取其一)
     */
    private String[] excludeTables = {};
    /**
     * 是否包含基础业务字段
     */
    private Boolean hasSuperEntity = Boolean.FALSE;
    /**
     * 是否包含包装器
     */
    private Boolean hasWrapper = Boolean.FALSE;
    /**
     * 基础业务字段
     */
    private String[] superEntityColumns = {"createTime", "createId", "createName", "updateTime", "updateName", "updateId", "delFlag"};
    /**
     * 租户字段
     */
    private String tenantColumn = "tenantId";
    /**
     * 是否启用swagger
     */
    private Boolean enableSwagger2 = Boolean.TRUE;
    /**
     * 数据库驱动名
     */
    private String driverName;
    /**
     * 数据库链接地址
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 数据库密码
     */
    private String password;
    /**
     * 创建者
     */
    private String author;

    /**
      * 生成代码
      * @return void
      * @author lbx
      * @date 2019/12/1 15:38
      * @version 1.0.0
     **/
    public void run() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //读取配置文件
        Properties props = getProperties();

        //设置输出路径
        String outputDir = getOutputDir();
        gc.setOutputDir(outputDir);
        String author = StringUtil.toStr(this.author,props.getProperty("author"));
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setSwagger2(enableSwagger2);
        gc.setFileOverride(true);
        gc.setOpen(false);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        String driverName = StringUtil.toStr(this.driverName, props.getProperty("spring.datasource.driver-class-name"));
        if (StringUtil.containsAny(driverName, DbType.MYSQL.getDb())) {
            dsc.setDbType(DbType.MYSQL);
            dsc.setTypeConvert(new MySqlTypeConvert());
        } else if (StringUtil.containsAny(driverName, DbType.POSTGRE_SQL.getDb())) {
            dsc.setDbType(DbType.POSTGRE_SQL);
            dsc.setTypeConvert(new PostgreSqlTypeConvert());
        } else {
            dsc.setDbType(DbType.ORACLE);
            dsc.setTypeConvert(new OracleTypeConvert());
        }
        dsc.setDriverName(driverName);
        dsc.setUrl(StringUtil.toStr(this.url, props.getProperty("spring.datasource.url")));
        dsc.setUsername(StringUtil.toStr(this.username, props.getProperty("spring.datasource.username")));
        dsc.setPassword(StringUtil.toStr(this.password, props.getProperty("spring.datasource.password")));
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);
        pc.setParent(packageName);
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setXml("mapper/conf");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(tablePrefix);
        if (includeTables.length > 0) {
            strategy.setInclude(includeTables);
        }
        if (excludeTables.length > 0) {
            strategy.setExclude(excludeTables);
        }
        if (hasSuperEntity) {
            strategy.setSuperEntityClass("org.tank.core.db.base.SuperEntity");
            strategy.setSuperEntityColumns(superEntityColumns);
            strategy.setSuperServiceClass("org.tank.core.db.base.SuperService");
            strategy.setSuperServiceImplClass("org.tank.core.db.base.SuperServiceImpl");
        }else{
            strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
            strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");
        }
        // 自定义 controller 父类
        strategy.setSuperControllerClass("org.tank.core.boot.ctrl.BaseController");
        strategy.setEntityBuilderModel(false);
        strategy.setEntityLombokModel(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        // 自定义配置 模板输出
        InjectionConfig cfg =getInjectionConfig();
        mpg.setCfg(cfg);
        mpg.execute();
    }

    /**
     * 创建模板自定义
     *
     * @return 配置InjectionConfig
     */
    private InjectionConfig getInjectionConfig() {
        String servicePackage = serviceName.split("-").length > 1 ? serviceName.split("-")[1] : serviceName;
        // 自定义配置
        Map<String, Object> map = new HashMap<>(16);
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                map.put("codeName", codeName);
                map.put("serviceName", serviceName);
                map.put("servicePackage", servicePackage);
                map.put("tenantColumn", tenantColumn);
                map.put("hasWrapper", hasWrapper);
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/entityVO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getOutputDir() + "/" + packageName.replace(".", "/") + "/" + "vo" + "/" + tableInfo.getEntityName() + "VO" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/entityDTO.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getOutputDir() + "/" + packageName.replace(".", "/") + "/" + "dto" + "/" + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        if (hasWrapper) {
            focList.add(new FileOutConfig("/templates/wrapper.java.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return getOutputDir() + "/" + packageName.replace(".", "/") + "/" + "wrapper" + "/" + tableInfo.getEntityName() + "Wrapper" + StringPool.DOT_JAVA;
                }
            });
        }
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 获取配置文件
     *
     * @return 配置Props
     */
    private Properties getProperties() {
        // 读取配置文件
        Resource resource = new ClassPathResource("/templates/default.properties");
        Properties props = new Properties();
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    /**
     * 生成到项目中
     *
     * @return outputDir
     */
    public String getOutputDir() {
        return (StringUtil.isBlank(packageDir) ? System.getProperty("user.dir") + "/tank-generator" : packageDir) + "/src/main/java";
    }
}

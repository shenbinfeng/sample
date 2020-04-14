package com.shen.sample.core.util;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.shen.sample.core.entity.Generator;

import java.util.*;

/**
 * @description: 代码自动生成器类
 * @author: Shenbinfeng
 * @create: 2020/2/8 14:49
 **/
public class CodeGenerator {
    private static Generator generator = YamlUtil.getCodingYaml();

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String moduleName = scanner("模块名");
        String moduleDes = scanner("模块说明");
        String[] tables = scanner("表名，多个英文逗号分割").split(",");
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(GlobalGenerate(projectPath));
        mpg.setDataSource(DaoSourceGenerate());
        mpg.setPackageInfo(PackageGenerate(moduleName));
        mpg.setTemplate(TemplateGenerate());
        mpg.setCfg(FileGenerate(moduleName, projectPath, moduleDes));
        mpg.setStrategy(StrategyGenerate(moduleName, tables));
        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    //全局配置
    private static GlobalConfig GlobalGenerate(String projectPath) {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(generator.getAuthor());
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        return gc;
    }

    //数据源配置
    private static DataSourceConfig DaoSourceGenerate() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(generator.getDatasource().getUrl());
        // dsc.setSchemaName("public");
        dsc.setDriverName(generator.getDatasource().getDriverName());
        dsc.setUsername(generator.getDatasource().getUsername());
        dsc.setPassword(generator.getDatasource().getPassword());
        return dsc;
    }

    //策略配置
    private static StrategyConfig StrategyGenerate(String moduleName, String[] tables) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(generator.getSuperEntityClass());
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(tables);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(moduleName + "_");
        return strategy;
    }

    //包配置
    private static PackageConfig PackageGenerate(String moduleName) {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName);
        pc.setParent(generator.getPackageParent());
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("serviceImpl");
        pc.setMapper("mapper");
        return pc;
    }

    //弃用默认项目结构
    private static TemplateConfig TemplateGenerate() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setEntity(null);
        templateConfig.setMapper(null);
        //templateConfig.setXml(generator.getTemplatePath().getMapperXml());
        templateConfig.setXml(null);
        return templateConfig;
    }

    private static InjectionConfig FileGenerate(String moduleName, String projectPath, String moduleDes) {
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("packageParent", generator.getPackageParent());
                map.put("moduleDes", moduleDes);
                this.setMap(map);
            }
        };
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(reSetFileOut(generator.getTemplatePath().getController(), projectPath + generator.getPath() + "/controller/" + moduleName + "/", "Controller" + StringPool.DOT_JAVA));
        focList.add(reSetFileOut(generator.getTemplatePath().getService(), projectPath + generator.getPath() + "/service/" + moduleName + "/", "Service" + StringPool.DOT_JAVA));
        focList.add(reSetFileOut(generator.getTemplatePath().getServiceImpl(), projectPath + generator.getPath() + "/serviceImpl/" + moduleName + "/", "ServiceImpl" + StringPool.DOT_JAVA));
        focList.add(reSetFileOut(generator.getTemplatePath().getEntity(), projectPath + generator.getPath() + "/entity/" + moduleName + "/", StringPool.DOT_JAVA));
        focList.add(reSetFileOut(generator.getTemplatePath().getMapper(), projectPath + generator.getPath() + "/mapper/" + moduleName + "/", "Mapper" + StringPool.DOT_JAVA));
        focList.add(reSetFileOut(generator.getTemplatePath().getInDto(), projectPath + generator.getPath() + "/dto/" + moduleName + "/", "InDTO" + StringPool.DOT_JAVA));
        focList.add(reSetFileOut(generator.getTemplatePath().getOutDto(), projectPath + generator.getPath() + "/dto/" + moduleName + "/", "OutDTO" + StringPool.DOT_JAVA));
        focList.add(reSetFileOut(generator.getTemplatePath().getQueryDto(), projectPath + generator.getPath() + "/dto/" + moduleName + "/", "QueryDTO" + StringPool.DOT_JAVA));
        focList.add(reSetFileOut(generator.getTemplatePath().getMapperXml(), projectPath + "/src/main/resources/mapper/" + moduleName + "/", "Mapper" + StringPool.DOT_XML));
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    private static FileOutConfig reSetFileOut(String templatePath, String filePath, String type) {
        return new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                if (filePath.contains("/service/")) {
                    return filePath + "I" + tableInfo.getEntityName() + type;
                }
                return filePath + tableInfo.getEntityName() + type;
            }
        };
    }
}

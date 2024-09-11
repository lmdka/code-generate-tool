package com.lmdka.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.lmdka.bean.BaseEntity;
import com.lmdka.config.DBConfig;

import java.sql.Types;
import java.util.Collections;

public class GenerateTool {
    public static void start() {
        FastAutoGenerator.create(DBConfig.url, DBConfig.username, DBConfig.password)
                .globalConfig(builder -> {
                    builder.author(DBConfig.author)
                            .disableOpenDir()// 设置作者
                            .outputDir(DBConfig.outputPath); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent(DBConfig.parentPageName) // 设置父包名
                                .moduleName(DBConfig.parentModuleName) // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, DBConfig.xmlOutputPath)) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                                builder.addInclude("sys_dict")// 设置需要生成的表名
                                        .addTablePrefix("sys_")
                                        // 实体类配置
                                        .entityBuilder()
//                                        .superClass(BaseEntity.class)
                                        .enableFileOverride()
                                        .disableSerialVersionUID()
                                        .enableLombok()
                                        .logicDeletePropertyName("delFlag")
                                        .logicDeleteColumnName("del_flag")
                                        .enableTableFieldAnnotation()
                                        .enableChainModel()
//                                        .javaTemplate("src/main/resources/template/entity.java.ftl")
                                        // 控制层配置
                                        .controllerBuilder()
                                        .enableFileOverride()
                                        .enableRestStyle()
//                                        .template("src/main/resources/template/controller.java.ftl")
                                        // mapper配置
                                        .mapperBuilder()
                                        .enableFileOverride()
//                                        .mapperTemplate("src/main/resources/template/mapper.java.ftl")
//                                        .mapperXmlTemplate("src/main/resources/template/mapper.xml.ftl")
                                        // service配置
                                        .serviceBuilder()
                                        .enableFileOverride()
//                                        .serviceTemplate("src/main/resources/template/service.java.ftl")
//                                        .serviceImplTemplate("src/main/resources/template/serviceImpl.java.ftl")


                                        .build()

                        // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine())// 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

    public static void main(String[] args) {
        start();
    }
}

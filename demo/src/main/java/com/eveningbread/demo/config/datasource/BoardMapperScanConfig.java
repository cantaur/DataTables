package com.eveningbread.demo.config.datasource;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardMapperScanConfig {

    private static final String BASE_PACKAGE = "com.eveningbread.demo.mapper";
    private String sqlSessionFactoryBeanName = "targetSqlSessionFactory";

    @Bean(name="targetMapperScan")
    public MapperScannerConfigurer targetScanner(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(BASE_PACKAGE);
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
        return mapperScannerConfigurer;

    }

}

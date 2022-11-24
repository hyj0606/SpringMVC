package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @ClassName MybatisConfig
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-14 11:16
 * @Version 1.0
 */
public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource ) throws IOException {

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        factoryBean.setDataSource(dataSource);

        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mappers/*Mapper.xml"));

        factoryBean.setTypeAliasesPackage("com.pojo");

        return factoryBean;

    }

    //扫描dao层对象
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();

        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        configurer.setBasePackage("com.dao");

        return configurer;
    }
}

package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-14 10:09
 * @Version 1.0
 */
/*
* 等待当前spring容器加载完成springConfig
* 再加载外部容器 MybatisConfig
* 再导入外部容器到当前容器中合并使用
* */

@Configuration
@PropertySource(value = {"dbinfo.properties"})
@Import(MybatisConfig.class)
@ComponentScan( basePackages = {"com.service"})
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    public DataSource dataSource( @Value("${jdbc.driver}") String driver,
                                       @Value("${jdbc.url}") String url,
                                       @Value("${jdbc.username}") String username,
                                       @Value("${jdbc.password}") String password){

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    //事务:
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager ds = new DataSourceTransactionManager();
        ds.setDataSource(dataSource);

        return ds;
    }
}

package com.config;

import com.utils.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName SpringMvcConfig
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-17 9:37
 * @Version 1.0
 */

@Configuration
@ComponentScan(basePackages = {"com.web"})
//@EnableWebMvc //自定义配置
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    //自定义springMVC容器配置工具:


    //拦截器工具
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        //自定义拦截器:
        MyInterceptor my1 = new MyInterceptor();

        //注册安装拦截器:
        registry.addInterceptor(my1).addPathPatterns("/*/*");

    }
}

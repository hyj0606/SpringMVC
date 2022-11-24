package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;

@Configuration
@ComponentScan( basePackages =  { "com.web"})
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        //1.先准备一个异常处理器
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();

        exceptionResolver.setDefaultErrorView("/error.jsp");

        //2.注册异常处理器
        exceptionResolvers.add(exceptionResolver);

    }
}

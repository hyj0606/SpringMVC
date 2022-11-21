package com.config;

import com.utils.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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

    //提供静态资源的访问配置:
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        //提供静态资源的访问配置:
        registry.addResourceHandler("/common/**").addResourceLocations("/common/");
        registry.addResourceHandler("/common/imgs/**").addResourceLocations("/common/imgs/");
        registry.addResourceHandler("/common/css/**").addResourceLocations("/common/css/");
        registry.addResourceHandler("/common/js/**").addResourceLocations("/common/js/");
    }

    //视图解析器: 根据提供的视图名称,搜索解析
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {

        //创建
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");

        registry.viewResolver(resolver);

    }
}

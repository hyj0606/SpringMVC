package com.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//充当web.xml
public class MyWebXml extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ SpringMvcConfig.class };
    }

    /*
    *   /* : 拦截所有请求.   含:  控制器方法 + 网页视图(jsp) + 静态资源(html,css,js,png).
    *   /  : 拦截部分请求.   含:  控制器方法 + 静态资源(放开: 静态资源访问配置).
    *   *.do : 拦截后缀为.do的请求.  注: 控制器方法后缀名必须声明为.do 例如: /t1.do
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    扩展过滤器实现中文参数编码指定:
    @Override
    protected Filter[] getServletFilters() {
        //通过返回过滤器进行生效:
        CharacterEncodingFilter    f1 = new CharacterEncodingFilter();
        f1.setEncoding("utf-8");

        return new Filter[]{ f1 };
    }



}

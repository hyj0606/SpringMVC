package com.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @ClassName MyWebXml
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-17 9:38
 * @Version 1.0
 */
//充当web.xml
public class MyWebXml extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /*
    * /* : 拦截所有请求. 含:控制器方法 + 网页视图(jsp) + 静态资源(html,css,js,)
    * /  : 拦截部分请求. 含: 控制器方法 + 静态资源
    *
    * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {

        //通过返回过滤器进行生效:
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");

        return new Filter[]{filter};

    }
}

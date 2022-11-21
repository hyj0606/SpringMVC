package com.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName MyExceptionResolver
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-21 11:05
 * @Version 1.0
 */

//仅在异常处理器默认为空时提供
@Component
public class MyExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //识别到了异常: e
        //String message = e.getMessage();

        ModelAndView mv = new ModelAndView();

        if (e instanceof NullPointerException){
            mv.setViewName("error1");
            mv.addObject("message","不能使用空对象");
        }else if (e instanceof ArithmeticException){
            mv.setViewName("error2");
            mv.addObject("message","算数运算失败");
        }else {
            mv.setViewName("error1");
            mv.addObject("message","请联系管理员");
        }
        return mv;
    }
}

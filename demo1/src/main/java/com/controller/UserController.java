package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-17 9:34
 * @Version 1.0
 */

@Controller
//@RequestMapping("/user")
public class UserController {

    @RequestMapping("/user1")
    public ModelAndView test1(){

        //传递数据并响应页面
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.jsp");
        mv.addObject("nickName","王");

        return mv;
    }

    @RequestMapping("/user2")
    public String test2(Model m, ModelMap mm){

        //传递数据并响应页面
        m.addAttribute("nickName","小花");
        mm.addAttribute("age","18");

        return "index.jsp";
    }

    @RequestMapping("/user3")
    public String test3(@ModelAttribute(name = "username") String username,@ModelAttribute(name = "password") String password){

        //传递数据并响应页面
        System.out.println("模拟登录...模拟失败");

        return "login.jsp";
    }

}

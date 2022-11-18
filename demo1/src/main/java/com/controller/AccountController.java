package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AccountController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-16 9:51
 * @Version 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    //默认请求测试方法
    @RequestMapping("test1")
    @ResponseBody //
    public String test1(){
        System.out.println("识别到了客户端请求...正在模拟请求...");

        return "success";
    }

    //其他请求测试方法
    @RequestMapping("test2")
    @ResponseBody
    public String test2(){
        System.out.println("识别到了客户端请求...正在模拟请求...");

        return "失败";
    }

}

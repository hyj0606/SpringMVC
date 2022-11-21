package com.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-21 9:48
 * @Version 1.0
 */
@RestController
public class UserController {

    @RequestMapping("/front/index")
    public String t1(){
        System.out.println("欢迎来到前台");
        return "ok1";
    }

    @RequestMapping("/admin/index")
    public String t2(){
        System.out.println("欢迎来到后台");
        return "ok2";
    }
}

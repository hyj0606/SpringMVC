package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserPageController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-21 10:13
 * @Version 1.0
 */
@Controller
public class UserPageController {

    @RequestMapping("/login")
    public String t1(){

        return "login.jsp";
    }

}

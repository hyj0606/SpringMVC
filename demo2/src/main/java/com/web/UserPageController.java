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
        return "login";
    }

    @RequestMapping("/index")
    public String t2(int no){
        if (no == 1) {
            Object o1 = null;
            String info = o1.toString(); //将产生:NullPointException异常
        }else if (no == 2){
            int a = 10/0; //将产生:ArithmeticException异常
        }

        return "index";
    }
}

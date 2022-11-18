package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-18 9:10
 * @Version 1.0
 */

@Controller
//@RequestMapping("/order")
public class OrderController {

    //响应: 视图网页.
    @RequestMapping("/order1")
    public String t1(){

        return "order.jsp";
    }

    @RequestMapping("/order2")
    public String t2(){

        //return "forward:order.jsp";
        return "redirect:order.jsp";
    }

}

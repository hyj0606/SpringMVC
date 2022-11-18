package com.controller;

import com.pojo.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BuyCarController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-18 9:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/buyCar")
public class BuyCarController {

    @RequestMapping("/t1")
    //@ResponseBody
    public String test1(){

        // 返回不同形式的数据
        return "success";
    }

    @RequestMapping("/t2")
    //@ResponseBody
    public Goods test2(){

        Goods goods = new Goods(1,"红茶",20);

        //返回不同形式的数据: 对象
        return goods;
    }
}

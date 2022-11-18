package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName GoodsController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-17 9:56
 * @Version 1.0
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

    /*
    * value = "/add": 映射路径
    * method = {RequestMethod.GET}: 约束客户端的http请求方法
    * params = {"name=value"} : 自定义请求参数
    * headers = {"name=value"} : 自定义请求头参数
    * consumes = "application/json" : 声明请求参数类型
    * produces = "application/json" : 通知浏览器相应格式类型
    *
    * */
    @RequestMapping( value = "/add", method = {RequestMethod.POST})
    public void addGoods(){
        System.out.println("模拟商品新增....");
    }

    //post请求方法+@RequestMapping
    @PostMapping(value = "del")
    public void delGoods(){
        System.out.println("模拟商品删除....");
    }

    //get请求方法+@RequestMapping
    @GetMapping(value = "edit")
    public void editGoods(){
        System.out.println("模拟商品修改....");
    }

    //其他映射路径声明注解: http请求发起的方法delete方式: @DeleteMapping
    //其他映射路径声明注解: http请求发起的方法put方式: @PutMapping

}

package com.controller;

import com.pojo.Goods;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @ClassName GoodsTypeController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-17 10:43
 * @Version 1.0
 */

@Controller
@RequestMapping("/goods_type")
public class GoodsTypeController {

    //解析: 请求参数
    /*
    * 方式一: 借助request请求对象解析
    *       request.getParameter();
    *
    * 方式二: 可以直接借助方法参数直接解析封装.
    *       String , int , Integer , 数组 , 集合 , 对象 ,
    * */
    @RequestMapping("/t1")
    @ResponseBody
    public String test1(HttpServletRequest request , HttpServletResponse response, HttpSession session){
        System.out.println("请求对象1为: "+request);
        System.out.println("请求对象2为: "+response);
        System.out.println("请求对象3为: "+session);
        String id = request.getParameter("id");
        System.out.println("请求参数为: "+id);

        return "OK" ;

    }

    /*
    * 备注: 传递参数类型不匹配将导致 400状态码.
    *
    * ?id=1 springmvc将: "1"==自动转换类型--->1 存储到参数变量age中
    * 没有传递id参数,springmvc将识别id为null,将null存储到参数age中
    * ?id=  springmvc将: "--自动转换类型---> 数值  此时转换报错.
    * */
    @RequestMapping("/t2")
    @ResponseBody
    public String test2( String username , Integer age){

        System.out.println("数据为: " + username + "---" + age);

        return "OK";
    }

    /*
    * 数组: 可直接传递封装
    * 集合: 会被解析为对象.springMVC将从集合对象内部找到对应名称的属性.
    *       解决问题? 如何根据集合名称传递封装参数呢?
    *       @RequestParam("scores")List<Integer> scores
    * */
    @RequestMapping("/t3")
    @ResponseBody
    public String test3( String[] subs , @RequestParam("scores")List<Integer> scores){

        System.out.println("数据为: "+subs);
        System.out.println("数据为: "+scores);

        return "OK";
    }

    /*
    * 对象类型参数,springMVC的处理方法:
    *       1.实例化参数对象: Goods g1 = new Goods();
    *       2.对象属性赋值: g1.goodsName = xxx
    *
    * */
    @RequestMapping("/t4")
    @ResponseBody
    public String test4(Goods g1){

        System.out.println("数据为: "+g1);
        System.out.println("数据为: "+g1.getGoodsName()+"---"+g1.getPrice());

        return "OK";
    }

    /*
    * 前提: 传递 { id:1, goodsName:'大米', price:100 }
    *
    * 对象类型参数,springMVC的处理方法:
    *       json对象--->java对象
    *   实现步骤:
    *       1.声明参数的值来自于请求主体中:@RequestBody Goods g1
    *       2.声明参数的类型为: consumes = "application/json"
    *       3.提供自动转化时需要的依赖: jackson-2.x
    *
    * */
    @RequestMapping(value = "/t5", consumes = "application/json")
    @ResponseBody
    public String test5(@RequestBody Goods g1 ){

        System.out.println("数据为: "+g1);
        System.out.println("数据为: "+g1.getGoodsName()+"---"+g1.getPrice());

        return "OK";
    }

    //日期类型: 客户端将传递格式: String("2022-11-18 08:48:00") ----> Date bornDate
    //解决: 1.@DateTimeFormat完成自动类型转换, 2.在springMVC在容器中可自定义类型转换器. String-->任意类型
    @RequestMapping("/t6")
    @ResponseBody
    public String test6(@DateTimeFormat (pattern = "yyyy-MM-dd hh:mm:ss") Date bornDate){

        System.out.println("数据为: " + bornDate);

        return "OK";
    }

}

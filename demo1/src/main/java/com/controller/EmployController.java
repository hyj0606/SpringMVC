package com.controller;

import com.pojo.Employ;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName EmployController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-18 11:51
 * @Version 1.0
 */
@RestController
@RequestMapping("/emp")
public class EmployController {

    //体现员工新增:
    @PutMapping
    public String add(Employ e1){
        System.out.println("模拟正在新增员工..."+e1.getEmpName()+"---"+e1.getId());
        return "1";
    }

    //体现员工修改:
    @PostMapping
    public String edit( Employ e1){
        System.out.println("模拟正在修改员工..."+e1.getEmpName()+"---"+e1.getId());
        return "2";
    }
    //体现员工删除:
    @DeleteMapping("/{id}")
    public String del(@PathVariable("id") int id ){// id通过URI传递解析
        System.out.println("模拟正在删除员工..." + id);
        return "3";
    }

    //体现员工查询:
    @GetMapping("/{id}")
    public String get(@PathVariable("id") int id ){// id通过URI传递解析
        System.out.println("模拟正在查询员工..."+id);
        return "4";
    }

}

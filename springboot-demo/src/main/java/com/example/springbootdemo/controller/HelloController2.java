package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Lin
 * 2023/5/8  20:41
 */
@RestController
public class HelloController2 {

    @RequestMapping(value="/hello2")
    public Object handle3() {
        System.out.println("收到了请求，已经处理完毕~");
        return "OK";
    }


    @RequestMapping(value="/hi2")
    public Object handle4() {
        System.out.println("收到了请求，已经处理完毕~");
        Employee employee = new Employee(1, "zhangsan", "male", "zhangsan@163.com");
        return employee;
    }

    @RequestMapping(value="/sendCommonParam")
    public Object handleCommonParam(String name,Integer age) {
        System.out.println("收到了普通参数请求，name:"+name+",age:"+age);
        return "普通参数请求 is OK";
    }

    @RequestMapping(value="/sendJsonParam")
    public Object handleJsonParam(
            //@RequestBody Employee employee
            @RequestBody Map<String,Object> employee
            ) {
        System.out.println("收到了JSON参数请求"+employee);
        return "JSON参数请求 is OK";
    }
}

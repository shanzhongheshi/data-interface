package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lin
 * 2023/5/8  20:41
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping(value="/hello")
    public Object handle() {
        System.out.println("收到了请求，已经处理完毕~");
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value="/hi")
    public Object handle2() {
        System.out.println("收到了请求，已经处理完毕~");
        Employee employee = new Employee(1, "zhangsan", "male", "zhangsan@163.com");
        return employee;
    }
}

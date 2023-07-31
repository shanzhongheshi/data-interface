package com.example.springbootdemo.controller;

import com.example.springbootdemo.bean.Employee;
import com.example.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lin
 * 2023/5/9  20:22
 */
@RestController
public class EmployeeController {
    //为什么用多态的形式？跟版本升级有什么关系吗？
    @Autowired
    private EmployeeService employeeService;

    //emp?op=select&id=&lastname=&gender=&email=
    @RequestMapping(value = "/emp")
    public Object handleEmployee(String op, Integer id, String lastname, String gender, String email) {
        Employee emp = new Employee(id, lastname, gender, email);
        if ("insert".equals(op)) {
            employeeService.insertEmployee(emp);
            return "OK";
        } else {
            if (id == null) {
                return "id非法";
            }
            switch ((op)) {
                case "select":
                    Employee employee = employeeService.getEmployeeById(id);
                    return employee == null ? "查无此人" : employee;
                case "delete":
                    employeeService.deleteEmployee(id);
                    return "OK";
                case "update":
                    employeeService.updateEmployee(emp);
                    return "OK";
                default:
                    return "OK";
            }
        }
    }

    @RequestMapping(value = "/getAllEmp")
    public Object handleGetAllEmp() {
        List<Employee> allEmployee = employeeService.getAllEmployee();
        return allEmployee;
    }
}

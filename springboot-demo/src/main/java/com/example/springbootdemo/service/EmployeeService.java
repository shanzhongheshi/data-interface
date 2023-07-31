package com.example.springbootdemo.service;

import com.example.springbootdemo.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lin
 * 2023/5/9  20:03
 */

public interface EmployeeService
{

    //查询单个员工
    Employee getEmployeeById(Integer id);

    //删除单个员工
    void deleteEmployee(Integer id);

    //更新单个员工
    void updateEmployee(Employee employee);

    //新增单个员工
    void insertEmployee(Employee employee);

    //查询所有员工
    List<Employee> getAllEmployee();
}

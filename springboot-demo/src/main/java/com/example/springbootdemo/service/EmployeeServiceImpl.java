package com.example.springbootdemo.service;

import com.example.springbootdemo.bean.Employee;
import com.example.springbootdemo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lin
 * 2023/5/9  20:12
 */
@Service
public class EmployeeServiceImpl  implements  EmployeeService{
    //TODO 正常不是通过SQLSessionFactory创建一个SqlSession，然后放入map，得到一个EmployeeMapper,SpringBoot不需要做这些吗？
    @Autowired
    private EmployeeMapper mapper;

    @Override
    public Employee getEmployeeById(Integer id) {
        System.out.println("查询之前 做事...");
        Employee e = mapper.getEmployeeById(id);
        System.out.println("查询之后，做事...");
        return e;
    }

    @Override
    public void deleteEmployee(Integer id) {
        mapper.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        mapper.updateEmployee(employee);
    }

    @Override
    public void insertEmployee(Employee employee) {
        mapper.insertEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> all = mapper.getAll();
        return all;
    }
}

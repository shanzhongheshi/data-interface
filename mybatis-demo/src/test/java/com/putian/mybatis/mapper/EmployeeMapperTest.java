package com.putian.mybatis.mapper;

import com.putian.mybatis.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Lin
 * 2023/5/7  14:26
 */
public class EmployeeMapperTest {
    //TODO 为什么不直接NEW一个EmployeeMapper?
    private SqlSessionFactory sqlSessionFactory;
    {
        String resource = "mybatis_config.xml";
        InputStream inputstream  =null;
        try {
             inputstream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
    }

    @Test
    public void getEmployeeById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //TODO 为什么要try finally？
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeById(1);
            System.out.println(employee);

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> allEmployee = mapper.getAll();
            System.out.println(allEmployee);

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertEmployee() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "zhangsan", "male", "zhangsan@163.com");
            mapper.insertEmployee(employee);

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateEmployee() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee e = mapper.getEmployeeById(2);
            e.setLastName("lisi");
            mapper.updateEmployee(e);

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteEmployee() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.deleteEmployee(1);

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getEmployeeCondition() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> list = mapper.getEmployeeCondition("male", 1);
            System.out.println(list);

        }finally {
            sqlSession.close();
        }
    }

}
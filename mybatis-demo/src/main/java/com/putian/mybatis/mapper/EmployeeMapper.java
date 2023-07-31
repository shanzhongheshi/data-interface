package com.putian.mybatis.mapper;

import com.putian.mybatis.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 定义访问数据的CRUD方法
 * 规格：编写什么类型的sql，就使用什么样的注解即可
 * @author Lin
 * 2023/5/7  14:07
 */
public interface EmployeeMapper {

    //查询单个员工
    @Select("select * from employee where id =#{id}")
    Employee getEmployeeById(Integer id);

    //查询所有员工
    @Select("select * from employee")
    List<Employee> getAll();

    //新增员工
    @Insert("insert into employee (last_name,gender,email) values (#{lastName}, #{gender}, #{email})")
    void insertEmployee(Employee employee);

    //更新员工
    @Update("update employee set last_name=#{lastName},gender= #{gender} ,email=#{email} where id= #{id} ")
    void updateEmployee(Employee employee);

    //删除员工
    @Delete("delete from employee where id= #{id}")
    void deleteEmployee(Integer id);

    //根据多个参数查询员工
    @Select("select * from employee where id > #{id} and gender = #{gender}")
    List<Employee> getEmployeeCondition(@Param("gender") String gender, @Param("id") Integer id);


}

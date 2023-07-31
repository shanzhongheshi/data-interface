package com.putian.springbootdatainterface.dao;

import com.putian.springbootdatainterface.bean.OrderStats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lin
 * 2023/5/14  17:27
 */
//Mybatis的注解，告知容器我这是一个Mapper，可以让Spring容器启动时，使用Mybatis的动态代理技术在容易中为接口创建一个实
//TODO MysqlMapper为什么是一个接口，而不是一个实体类?
@Mapper
public interface MysqlMapper {
    @Select("SELECT" +
            " DATE_FORMAT(dt,'%H:%i') as dt " +
            " ,SUM(ordercount) as orderCount " +
            " ,sum(refundcount) as refundCount " +
            "FROM `di`" +
            "where Date(dt) = #{date}" +
            "group by  DATE_FORMAT(dt,'%H:%i')" +
            ";")
    List<OrderStats> queryOrderStatsByDate(@Param("date") String date);
}

package com.putian.springbootdatainterface.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lin
 * 2023/5/14  17:29
 */
//使用lombook的注解创建Java Bean,Java Bean相当于是数据模型
@Data
@NoArgsConstructor   //无参构造器
@AllArgsConstructor  //有参构造器
public class OrderStats {
    private String dt;
    private Integer orderCount;
    private Integer refundCount;
}

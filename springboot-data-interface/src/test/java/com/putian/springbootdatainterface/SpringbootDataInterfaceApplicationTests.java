package com.putian.springbootdatainterface;

import com.alibaba.fastjson.JSONObject;
import com.putian.springbootdatainterface.service.DataInterfaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDataInterfaceApplicationTests {
    @Autowired
    private DataInterfaceService dataInterfaceService;
    @Test
    void testMysql() {
        JSONObject jsonObject = dataInterfaceService.queryOrderStatsByDate("2023-05-01");
        System.out.println(jsonObject);
    }

}

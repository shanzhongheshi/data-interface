package com.putian.springbootdatainterface.controller;

import com.putian.springbootdatainterface.service.DataInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lin
 * 2023/5/15  8:16
 */
@RestController
public class DataInterfaceController {
    @Autowired
    private DataInterfaceService dataInterfaceService;

    @RequestMapping(value = "/queryOrderStats")
    public Object queryOrderStatsByDate(String dt){

        if (StringUtils.hasText(dt)){
            return dataInterfaceService.queryOrderStatsByDate(dt);
        }else{
            return "NOT OK";
        }

    }

}


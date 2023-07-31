package com.putian.springbootdatainterface.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;


/**
 * @author Lin
 * 2023/5/14  17:21
 */
public interface DataInterfaceService {
    //查询Mysql中某天分钟级别的下单和退单数
    JSONObject queryOrderStatsByDate(String dt);

    //从redis中查询各手机的访问量
    JSONObject queryVisitStatsTop5();

    //从ck中查询各手机当日的销售额
    JSONObject querySalesAmountToday();

    //从ck统计每个手机品牌在昨日和今日的总销售额
    JSONObject querySalesAmount();

    //从ES中查询各来源数
    JSONObject querySourceData();

    //从ES中查询行业信息
    JSONObject queryIndustryStats();

    //从hbase中查询各省份今日的订单数和销售额
    JSONObject queryProvinceStatToday();

    //从hbase中查询各省份的目标完成进度
    JSONObject queryProviceCompletion(String city);
}

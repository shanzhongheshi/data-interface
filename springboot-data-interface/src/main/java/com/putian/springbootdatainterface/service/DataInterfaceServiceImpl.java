package com.putian.springbootdatainterface.service;

import com.alibaba.fastjson.JSONObject;
import com.putian.springbootdatainterface.bean.OrderStats;
import com.putian.springbootdatainterface.dao.MysqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lin
 * 2023/5/14  18:09
 */
//这是springframework提供的一个注解，用来告知容器，这是一个Service，可以让Spring容器启动时，在容器中为接口一个实例
@Service
public class DataInterfaceServiceImpl implements DataInterfaceService {

    @Autowired
    private MysqlMapper mysqlMapper;

    @Override
    public JSONObject queryOrderStatsByDate(String dt) {
        //查询到的数据
        List<OrderStats> orderStats = mysqlMapper.queryOrderStatsByDate(dt);

        //声明最终返回的数据对象
        JSONObject result = new JSONObject();
        JSONObject dataJO = new JSONObject();
        JSONObject orderJO = new JSONObject();
        JSONObject refundJO = new JSONObject();
        List<String> categories = new ArrayList<>();
        List<Integer> orderCountData = new ArrayList<>();
        List<Integer> refundCountData = new ArrayList<>();
        List<JSONObject> seriesData = new ArrayList<>();

        //按照规定的格式返回数据
        //封装series部分
        for (OrderStats orderStat : orderStats) {
            categories.add(orderStat.getDt());
            orderCountData.add(orderStat.getOrderCount());
            refundCountData.add(orderStat.getRefundCount());
        }

        orderJO.put("name","新增订单数");
        orderJO.put("data",orderCountData);

        refundJO.put("name","退单数");
        refundJO.put("data",refundCountData);

        seriesData.add(orderJO);
        seriesData.add(refundJO);

        //封装data
        dataJO.put("categories",categories);
        dataJO.put("series",seriesData);

        //封装最外层的result
        result.put("status",0);
        result.put("msg","");
        result.put("data",dataJO);
        return result ;
    }

    @Override
    public JSONObject queryVisitStatsTop5() {
        return null;
    }

    @Override
    public JSONObject querySalesAmountToday() {
        return null;
    }

    @Override
    public JSONObject querySalesAmount() {
        return null;
    }

    @Override
    public JSONObject querySourceData() {
        return null;
    }

    @Override
    public JSONObject queryIndustryStats() {
        return null;
    }

    @Override
    public JSONObject queryProvinceStatToday() {
        return null;
    }

    @Override
    public JSONObject queryProviceCompletion(String city) {
        return null;
    }
}

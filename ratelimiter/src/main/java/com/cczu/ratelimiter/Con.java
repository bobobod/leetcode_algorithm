package com.cczu.ratelimiter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jianzhen.yin
 * @date 2020/9/23
 */
public class Con {
    private static final String str ="{\"Paging\":{\"PageSize\":4,\"PageIndex\":1,\"TotalRecords\":5},\"Result\":[{\"KeyNo\":\"p283698248c8c18693974f0ed8e2c488\",\"StockName\":\"程维\",\"StockType\":\"自然人股东\",\"StockPercent\":\"49.1900%\",\"ShouldCapi\":\"491.9\",\"ShoudDate\":\"2032-07-01\"},{\"KeyNo\":\"p8af150193605524f769fd8de78f9bf0\",\"StockName\":\"王刚\",\"StockType\":\"自然人股东\",\"StockPercent\":\"48.2250%\",\"ShouldCapi\":\"482.25\",\"ShoudDate\":\"2032-07-01\"},{\"KeyNo\":\"pbd67b003e5006fa2147953e17495228\",\"StockName\":\"张博\",\"StockType\":\"自然人股东\",\"StockPercent\":\"1.5530%\",\"ShouldCapi\":\"15.53\",\"ShoudDate\":\"2032-07-01\"},{\"KeyNo\":\"pa0cfb811658ed88d645cbf45f495cce\",\"StockName\":\"吴睿\",\"StockType\":\"自然人股东\",\"StockPercent\":\"0.7230%\",\"ShouldCapi\":\"7.23\",\"ShoudDate\":\"2032-07-01\"}],\"Status\":\"200\",\"Message\":\"查询成功\",\"OrderNumber\":\"ECIPARTNER2020092411041475391137\"}";

    public Map<String,Object> parse(String response){
       response ="{\"Paging\":{\"PageSize\":4,\"PageIndex\":1,\"TotalRecords\":5},\"Result\":[{\"KeyNo\":\"p283698248c8c18693974f0ed8e2c488\",\"StockName\":\"程维\",\"StockType\":\"自然人股东\",\"StockPercent\":\"49.1900%\",\"ShouldCapi\":\"491.9\",\"ShoudDate\":\"2032-07-01\"},{\"KeyNo\":\"p8af150193605524f769fd8de78f9bf0\",\"StockName\":\"王刚\",\"StockType\":\"自然人股东\",\"StockPercent\":\"48.2250%\",\"ShouldCapi\":\"482.25\",\"ShoudDate\":\"2032-07-01\"},{\"KeyNo\":\"pbd67b003e5006fa2147953e17495228\",\"StockName\":\"张博\",\"StockType\":\"自然人股东\",\"StockPercent\":\"1.5530%\",\"ShouldCapi\":\"15.53\",\"ShoudDate\":\"2032-07-01\"},{\"KeyNo\":\"pa0cfb811658ed88d645cbf45f495cce\",\"StockName\":\"吴睿\",\"StockType\":\"自然人股东\",\"StockPercent\":\"0.7230%\",\"ShouldCapi\":\"7.23\",\"ShoudDate\":\"2032-07-01\"}],\"Status\":\"200\",\"Message\":\"查询成功\",\"OrderNumber\":\"ECIPARTNER2020092411041475391137\"}";

        Map<String, Object> finalResult = new HashMap<>();
        JSONObject respObj = JSON.parseObject(response);
        if (respObj != null){
            JSONArray partnerArr = new JSONArray();
            JSONArray resultArr = respObj.getJSONArray("Result");
            for (int i = 0; i < resultArr.size(); i++) {
                JSONObject item = resultArr.getJSONObject(i);
                String keyNo = item.getString("KeyNo");
                String stockName = item.getString("StockName");
                String stockPercent = item.getString("StockPercent");
                String shouldCapi = item.getString("ShouldCapi");
                // 组装结果集
                JSONObject partner = new JSONObject();
                partner.put("StockName",stockName);
                partner.put("stockPercent",stockPercent);
                partner.put("shouldCapi",shouldCapi);
                partner.put("keyNo",shouldCapi);
                partnerArr.add(partner);
            }
            finalResult.put("partnerList",partnerArr);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Con con = new Con();
        System.out.println(con.parse("hello"));
    }
}

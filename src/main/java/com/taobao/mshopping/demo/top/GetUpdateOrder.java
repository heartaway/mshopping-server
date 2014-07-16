package com.taobao.mshopping.demo.top;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TradeTaeAdjustRequest;
import com.taobao.api.request.TradeTaeBuildRequest;
import com.taobao.api.response.TradeTaeAdjustResponse;
import com.taobao.api.response.TradeTaeBuildResponse;

/**
 * Created by xinyuan on 14/7/8.
 */
public class GetUpdateOrder extends BaseTopClient {


    public static String getUpdateOrderResp(String sessionKey, String updateJson) {
        String result = "";
        try {
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            TradeTaeAdjustRequest req = new TradeTaeAdjustRequest();
            req.setAdjustTradeBuyQuery(updateJson);
            TradeTaeAdjustResponse response = client.execute(req, sessionKey);
            if (response.isSuccess()) {
                result = response.getAdjustOrderResp().toString();
            } else {
                result = response.getBody();
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return result;
    }
}

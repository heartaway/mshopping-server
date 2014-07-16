package com.taobao.mshopping.demo.top;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TradeTaeAdjustRequest;
import com.taobao.api.request.TradeTaeCreateRequest;
import com.taobao.api.response.TradeTaeAdjustResponse;
import com.taobao.api.response.TradeTaeCreateResponse;

/**
 * Created by xinyuan on 14/7/8.
 */
public class GetCreateOrder extends BaseTopClient {


    public static String getCreateOrderResp(String sessionKey, String submitJson) {
        String result = "";
        try {
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            TradeTaeCreateRequest req = new TradeTaeCreateRequest();
            req.setOrderInfo(submitJson);
            TradeTaeCreateResponse response = client.execute(req, sessionKey);
            result = response.getBody();
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return result;
    }
}

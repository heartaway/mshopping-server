package com.taobao.mshopping.demo.top;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaTaeAlipayUrlGetRequest;
import com.taobao.api.response.AlibabaTaeAlipayUrlGetResponse;

/**
 * Created by xinyuan on 14/7/8.
 */
public class GetPayOrder extends BaseTopClient {


    public static String getPayOrderResp(String tradeNos, String returnUrl) {
        String result = "";
        try {
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            AlibabaTaeAlipayUrlGetRequest req = new AlibabaTaeAlipayUrlGetRequest();
            req.setTradeNos(tradeNos);
            req.setReturnUrl(returnUrl);
            AlibabaTaeAlipayUrlGetResponse response = client.execute(req);
            result = response.getBody();
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return result;
    }
}

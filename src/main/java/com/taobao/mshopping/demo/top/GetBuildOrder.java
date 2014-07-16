package com.taobao.mshopping.demo.top;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaTaeDetailPicwordGetRequest;
import com.taobao.api.request.TradeTaeBuildRequest;
import com.taobao.api.response.AlibabaTaeDetailPicwordGetResponse;
import com.taobao.api.response.TradeTaeBuildResponse;

/**
 * Created by xinyuan on 14/7/8.
 */
public class GetBuildOrder extends BaseTopClient {


    public static String getBuildOrderResp(String sessionKey, String itemsJson) {
        String result = "";
        try {
            TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
            TradeTaeBuildRequest req = new TradeTaeBuildRequest();
            req.setBuildOrderReq(itemsJson);
            TradeTaeBuildResponse response = client.execute(req, sessionKey);
            if (response.isSuccess()) {
                result = response.getBuildOrderResp().getMsgInfo();
            } else {
                result = response.getBody();
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return result;
    }
}

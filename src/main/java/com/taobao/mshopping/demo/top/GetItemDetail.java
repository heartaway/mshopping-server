package com.taobao.mshopping.demo.top;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.request.AlibabaTaeDetailBasicGetRequest;
import com.taobao.api.request.AlibabaTaeDetailPicwordGetRequest;
import com.taobao.api.response.AlibabaTaeDetailBasicGetResponse;
import com.taobao.api.response.AlibabaTaeDetailPicwordGetResponse;

/**
 * Created by xinyuan on 14/6/23.
 */
public class GetItemDetail extends BaseTopClient {

    /**
     * 获取商品详情
     *
     * @param itemId
     */
    public static Item getItemDetail(Long itemId) {
        Item item = null;
        try {
            TaobaoClient client=new DefaultTaobaoClient(url, appkey, secret);
            AlibabaTaeDetailPicwordGetRequest req=new AlibabaTaeDetailPicwordGetRequest();
            req.setAuctionId(itemId);
            AlibabaTaeDetailPicwordGetResponse response = client.execute(req);
        } catch (ApiException e) {

        }
        return item;
    }
}

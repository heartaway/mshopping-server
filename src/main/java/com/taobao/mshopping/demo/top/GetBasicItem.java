package com.taobao.mshopping.demo.top;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.request.AlibabaTaeDetailBasicGetRequest;
import com.taobao.api.request.ItemGetRequest;
import com.taobao.api.response.AlibabaTaeDetailBasicGetResponse;
import com.taobao.api.response.ItemGetResponse;

/**
 * Created by xinyuan on 14/6/23.
 */
public class GetBasicItem extends BaseTopClient {

    /**
     * 获取商品的基本参数信息
     *
     * @param itemId
     */
    public static Item getBasicItem(Long itemId) {
        Item item = null;
        try {
            TaobaoClient client=new DefaultTaobaoClient(url, appkey, secret);
            AlibabaTaeDetailBasicGetRequest req=new AlibabaTaeDetailBasicGetRequest();
            req.setAuctionId(itemId);
            AlibabaTaeDetailBasicGetResponse response = client.execute(req);
        } catch (ApiException e) {

        }
        return item;
    }
}

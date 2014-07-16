package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.top.GetCreateOrder;
import com.taobao.mshopping.demo.top.GetUpdateOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xinyuan on 14/7/9.
 * 创建订单接口
 */
@Controller
@RequestMapping("/api")
public class CreateOrderApi {

    @ResponseBody
    @RequestMapping(value = "/order/createorder", method = RequestMethod.POST)
    public String getCreateOrderByPost(@RequestParam("sessionKey") String sessionKey, @RequestParam("submitJson") String submitJson) {
        return GetCreateOrder.getCreateOrderResp(sessionKey, submitJson);
    }


    @ResponseBody
    @RequestMapping(value = "/order/createorder/get", method = RequestMethod.GET)
    public String getCreateOrderByGet(@RequestParam("sessionKey") String sessionKey, @RequestParam("submitJson") String submitJson) {
        return GetCreateOrder.getCreateOrderResp(sessionKey, submitJson);
    }


}

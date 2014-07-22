package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.top.GetPayOrder;
import com.taobao.mshopping.demo.util.SecurityKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xinyuan on 14/7/11.
 * 商品支付
 */
@Controller
@RequestMapping("/api")
public class PayOrderApi {

    @ResponseBody
    @RequestMapping(value = "/order/getpayurl", method = RequestMethod.POST)
    public String getCreateOrderByPost(@RequestParam("tradeNos") String tradeNos, @RequestParam("returnUrl") String returnUrl, @RequestParam("securityKey") String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            return GetPayOrder.getPayOrderResp(tradeNos, returnUrl);
        } else {
            return "";
        }
    }

}

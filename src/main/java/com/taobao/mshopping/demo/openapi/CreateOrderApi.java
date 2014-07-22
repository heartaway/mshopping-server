package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.constant.MshoppingConstant;
import com.taobao.mshopping.demo.top.GetBuildOrder;
import com.taobao.mshopping.demo.top.GetCreateOrder;
import com.taobao.mshopping.demo.top.GetUpdateOrder;
import com.taobao.mshopping.demo.util.SecurityKey;
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
    public String getCreateOrderByPost(@RequestParam("sessionKey") String sessionKey, @RequestParam("submitJson") String submitJson,@RequestParam("securityKey")String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            return GetCreateOrder.getCreateOrderResp(sessionKey, submitJson);
        }else{
            return "";
        }
    }


}

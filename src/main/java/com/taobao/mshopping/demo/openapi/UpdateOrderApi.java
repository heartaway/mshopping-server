package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.top.GetUpdateOrder;
import com.taobao.mshopping.demo.util.SecurityKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xinyuan on 14/7/9.
 * 订单联动修改接口
 */
@Controller
@RequestMapping("/api")
public class UpdateOrderApi {

    @ResponseBody
    @RequestMapping(value = "/order/updateorder")
    public String getUpdateOrderByPost(@RequestParam("sessionKey") String sessionKey, @RequestParam("updateJson") String updateJson, @RequestParam("securityKey") String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            return GetUpdateOrder.getUpdateOrderResp(sessionKey, updateJson);
        } else {
            return "";
        }
    }


}

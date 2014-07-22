package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.top.GetBuildOrder;
import com.taobao.mshopping.demo.util.SecurityKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xinyuan on 14/7/9.
 */
@Controller
@RequestMapping("/api")
public class BuildOrderApi {

    @ResponseBody
    @RequestMapping(value = "/order/buildorder", method = RequestMethod.POST)
    public String getBuildOrderByPost(@RequestParam("sessionKey")String sessionKey, @RequestParam("itemsJson")String itemsJson,@RequestParam("securityKey")String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            return GetBuildOrder.getBuildOrderResp(sessionKey, itemsJson);
        }else{
            return "";
        }
    }

}

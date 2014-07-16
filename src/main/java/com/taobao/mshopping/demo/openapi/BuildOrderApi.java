package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.top.GetBuildOrder;
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
    public String getBuildOrderByPost(@RequestParam("sessionKey")String sessionKey, @RequestParam("itemsJson")String itemsJson) {
        return GetBuildOrder.getBuildOrderResp(sessionKey, itemsJson);
    }


    @ResponseBody
    @RequestMapping(value = "/order/buildorder/get", method = RequestMethod.GET)
    public String getBuildOrderByGet(@RequestParam("sessionKey")String sessionKey, @RequestParam("itemsJson")String itemsJson) {
        return GetBuildOrder.getBuildOrderResp(sessionKey, itemsJson);
    }


}

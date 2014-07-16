package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.top.GetUpdateOrder;
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
    @RequestMapping(value = "/order/updateorder", method = RequestMethod.POST)
    public String getUpdateOrderByPost(@RequestParam("sessionKey") String sessionKey, @RequestParam("updateJson") String updateJson) {
        return GetUpdateOrder.getUpdateOrderResp(sessionKey, updateJson);
    }


    @ResponseBody
    @RequestMapping(value = "/order/updateorder/get", method = RequestMethod.GET)
    public String getUpdateOrderByGet(@RequestParam("sessionKey") String sessionKey, @RequestParam("updateJson") String updateJson) {
        return GetUpdateOrder.getUpdateOrderResp(sessionKey, updateJson);
    }


}

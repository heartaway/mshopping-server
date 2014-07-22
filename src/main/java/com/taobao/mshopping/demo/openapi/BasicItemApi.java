package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.constant.MshoppingConstant;
import com.taobao.mshopping.demo.top.GetBasicItem;
import com.taobao.mshopping.demo.util.SecurityKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xinyuan on 14/7/5.
 */
@Controller
@RequestMapping("/api")
public class BasicItemApi {

    /**
     * 获取商品基本信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/item/basicinfo/{itemId}", method = RequestMethod.POST)
    public String getBasicItemInfromation(@PathVariable Long itemId, @RequestParam("securityKey") String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            return GetBasicItem.getBasicItem(itemId);
        } else {
            return "";
        }

    }

}

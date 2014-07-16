package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.top.GetBasicItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "/item/basicinfo/{itemId}", method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String getBasicItemInfromation(@PathVariable Long itemId) {
        return GetBasicItem.getBasicItem(itemId);
    }

}

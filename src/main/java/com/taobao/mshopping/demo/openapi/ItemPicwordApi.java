package com.taobao.mshopping.demo.openapi;

import com.taobao.mshopping.demo.top.GetBasicItem;
import com.taobao.mshopping.demo.top.GetItemPicword;
import com.taobao.mshopping.demo.util.SecurityKey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xinyuan on 14/7/5.
 */
@Controller
@RequestMapping("/api")
public class ItemPicwordApi {

    /**
     * 获取商品图文信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/item/picwordinfo/{itemId}")
    public String getRichItemInfromation(@PathVariable Long itemId,@RequestParam("securityKey")String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            return GetItemPicword.getItemPicword(itemId);
        }else {
            return "";
        }
    }

}

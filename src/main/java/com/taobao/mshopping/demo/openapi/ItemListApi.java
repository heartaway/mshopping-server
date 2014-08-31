package com.taobao.mshopping.demo.openapi;

import com.alibaba.pt.commons.persistence.page.Page;
import com.taobao.mshopping.demo.constant.MshoppingConstant;
import com.taobao.mshopping.demo.model.PushedItemDO;
import com.taobao.mshopping.demo.persistence.dao.PushedItemDao;
import com.taobao.mshopping.demo.top.GetBasicItem;
import com.taobao.mshopping.demo.util.JsonDateValueProcessor;
import com.taobao.mshopping.demo.util.SecurityKey;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by xinyuan on 14/6/23.
 */
@Controller
@RequestMapping("/api")
public class ItemListApi {

    @Resource
    PushedItemDao pushedItemDao;

    /**
     * 查看更多商品
     * <p/>
     * pageIndex 从 0 开始
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/itemlist/more/{categoryId}/{pageIndex}")
    public Object viewMoreItemView(@PathVariable Integer categoryId, @PathVariable Integer pageIndex,@RequestParam("securityKey")String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            PushedItemDO pushedItemDO = new PushedItemDO();
            pushedItemDO.setCategoryId(categoryId);
            Page<PushedItemDO> pushedItemDOPage = pushedItemDao.page("page", pushedItemDO, pageIndex * MshoppingConstant.SIZE_PER_PAGE);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            JSONArray json = JSONArray.fromObject(pushedItemDOPage.getDatas(), jsonConfig);
            return json;
        }else{
            return "";
        }
    }



    @ResponseBody
    @RequestMapping(value = "/itemlist/more/{categoryId}/{pageIndex}/{type}")
    public Object viewMoreItemViewWithType(@PathVariable Integer categoryId, @PathVariable Integer pageIndex,@RequestParam("securityKey")String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            PushedItemDO pushedItemDO = new PushedItemDO();
            pushedItemDO.setCategoryId(categoryId);
            Page<PushedItemDO> pushedItemDOPage = pushedItemDao.page("page", pushedItemDO, pageIndex * MshoppingConstant.SIZE_PER_PAGE);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            JSONArray json = JSONArray.fromObject(pushedItemDOPage.getDatas(), jsonConfig);
            return json.toString();
        }else{
            return "";
        }
    }

    /**
     * 获取新商品
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/itemlist/new/{categoryId}/{time}")
    public Object getNewItemView(@PathVariable Integer categoryId, @PathVariable Long time,@RequestParam("securityKey")String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            PushedItemDO pushedItemDO = new PushedItemDO();
            pushedItemDO.setCategoryId(categoryId);
            List<PushedItemDO> pushedItemDOs;
            if (time == 0L) {
                pushedItemDOs = pushedItemDao.page("page", pushedItemDO, 0).getDatas();
            } else {
                pushedItemDO.setPushTime(new Date(time));
                pushedItemDOs = pushedItemDao.find("findItemsBeyondDate", pushedItemDO);
            }
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            JSONArray json = JSONArray.fromObject(pushedItemDOs, jsonConfig);
            return json;
        }else{
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/itemlist/new/{categoryId}")
    public Object getNewItemViewTimeIsNull(@PathVariable Integer categoryId,@RequestParam("securityKey")String securityKey) {
        if (SecurityKey.getKey().equals(securityKey)) {
            PushedItemDO pushedItemDO = new PushedItemDO();
            pushedItemDO.setCategoryId(categoryId);
            List<PushedItemDO> pushedItemDOs;
            pushedItemDOs = pushedItemDao.page("page", pushedItemDO, 0).getDatas();
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            JSONArray json = JSONArray.fromObject(pushedItemDOs, jsonConfig);
            return json;
        }else{
            return "";
        }
    }

}

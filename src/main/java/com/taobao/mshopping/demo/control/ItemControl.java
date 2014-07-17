package com.taobao.mshopping.demo.control;

import com.alibaba.pt.commons.persistence.page.Page;
import com.taobao.mshopping.demo.constant.MshoppingConstant;
import com.taobao.mshopping.demo.model.ItemHouseDO;
import com.taobao.mshopping.demo.model.PushBufferDO;
import com.taobao.mshopping.demo.model.PushOptDO;
import com.taobao.mshopping.demo.model.PushedItemDO;
import com.taobao.mshopping.demo.persistence.dao.ItemHouseDao;
import com.taobao.mshopping.demo.persistence.dao.PushBufferDao;
import com.taobao.mshopping.demo.persistence.dao.PushOptDao;
import com.taobao.mshopping.demo.persistence.dao.PushedItemDao;
import com.taobao.mshopping.demo.top.GetBasicItem;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xinyuan on 14/6/23.
 */
@Controller
@RequestMapping("/admin")
public class ItemControl {

    @Resource
    ItemHouseDao itemHouseDao;

    @Resource
    PushBufferDao pushBufferDao;

    @Resource
    PushOptDao pushOptDao;

    @Resource
    PushedItemDao pushedItemDao;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexNoPath() {
        ModelAndView model = new ModelAndView("index/index");
        return model;
    }

    /**
     * 添加商品
     *
     * @return
     */
    @RequestMapping(value = "/item/add", method = RequestMethod.GET)
    public ModelAndView addItemView() {
        ModelAndView model = new ModelAndView("item/addItem");
        return model;
    }

    /**
     * 添加商品
     *
     * @return
     */
    @RequestMapping(value = "/item/add.do", method = RequestMethod.GET)
    public ModelAndView doAddItem(String itemId) {
        ModelAndView model = new ModelAndView("item/addItem");
        if (StringUtils.isBlank(itemId)) {
            model.addObject("error-msg", "商品ID不能为空");
            return model;
        }
        ItemHouseDO itemHouseDO = new ItemHouseDO();
        String json = GetBasicItem.getBasicItem(Long.valueOf(itemId));
        try {
            JSONObject jsonObject = JSONObject.fromObject(json);
            String result = jsonObject.getString("ret");
            if (result == null || !result.contains("SUCCESS")) {
                model.addObject("error-msg", "添加商品失败");
                return model;
            }
            JSONObject dateJsonObject = jsonObject.getJSONObject("data");

            JSONObject itemInfoObject = dateJsonObject.getJSONObject("itemInfoModel");
            JSONArray apiStackArray = dateJsonObject.getJSONArray("apiStack");
            String price = apiStackArray.getJSONObject(0).getJSONObject("value").getJSONObject("data").getJSONObject("itemInfoModel").getJSONArray("priceUnits").getJSONObject(0).getString("price");
            JSONArray picArray = itemInfoObject.getJSONArray("picsPath");
            //这里为商品列表页展示数据使用，所以只展示一张图片
            if (picArray != null && picArray.size() > 0) {
                itemHouseDO.setPic((String) picArray.get(0));
            }
            itemHouseDO.setItemId(itemInfoObject.getLong("itemId"));
            itemHouseDO.setTitle(itemInfoObject.getString("title"));
            itemHouseDO.setPrice(Double.valueOf(price));
            itemHouseDO.setIsPush(false);
        } catch (Exception e) {

        }


        Long id = itemHouseDao.create(itemHouseDO);
        if (id <= 0) {
            model.addObject("error-msg", "添加商品失败");
            return model;
        }
        model.addObject("item", itemHouseDO);
        model.addObject("success-msg", "商品添加成功");
        return model;
    }

    /**
     * 展示所有商品列表
     *
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "/item/selectitem", method = RequestMethod.GET)
    public ModelAndView getItemList4AddPushList(@RequestParam(defaultValue = "1") Integer pageIndex) {
        ModelAndView model = new ModelAndView("/item/selectItem");
        ItemHouseDO itemHouseDO = new ItemHouseDO();
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        Page<ItemHouseDO> itemHouseDOs = itemHouseDao.page("page", itemHouseDO, (pageIndex - 1) * MshoppingConstant.SIZE_PER_PAGE);
        if (itemHouseDOs.getDatas().size() == 0 && itemHouseDOs.getRecordCount() != 0) {
            pageIndex = pageIndex - 1;
            itemHouseDOs = itemHouseDao.page("page", itemHouseDO, (pageIndex - 1) * MshoppingConstant.SIZE_PER_PAGE);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.addObject("dateFormat", dateFormat);
        model.addObject("pageIndex", pageIndex);
        model.addObject("totalPageSize", itemHouseDOs.getPageSize());
        model.addObject("items", itemHouseDOs.getDatas());
        return model;
    }

    /**
     * 逻辑删除商品
     *
     * @param id
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "/item/deleteitem", method = RequestMethod.GET)
    public ModelAndView deleteItem(Long id, Integer pageIndex) {
        PushBufferDO pushBufferDO = new PushBufferDO();
        pushBufferDO.setItemHouseId(id);
        int size = pushBufferDao.find(pushBufferDO).size();
        if (size > 0) {
            pushBufferDao.delete("deleteByParam", pushBufferDO);
        }
        itemHouseDao.delete(id);
        ModelAndView model = getItemList4AddPushList(pageIndex);
        return model;
    }


    /**
     * 添加商品到 待推送列表
     *
     * @param id
     * @param pageIndex
     * @return
     */
    @RequestMapping(value = "/item/addtopushbuffer", method = RequestMethod.GET)
    public ModelAndView addItemToPushBufferList(Long id, Integer pageIndex) {
        ItemHouseDO itemHouseDO = itemHouseDao.load(id);
        PushBufferDO pushBufferDO = new PushBufferDO();
        pushBufferDO.setItemId(itemHouseDO.getItemId());
        pushBufferDO.setItemHouseId(itemHouseDO.getId());
        pushBufferDO.setPicUrl(itemHouseDO.getPic());
        pushBufferDO.setPrice(itemHouseDO.getPrice());
        pushBufferDO.setTitle(itemHouseDO.getTitle());
        pushBufferDao.create(pushBufferDO);
        itemHouseDO.setIsPush(true);
        itemHouseDao.update(itemHouseDO);
        ModelAndView model = getItemList4AddPushList(pageIndex);
        return model;
    }

    @RequestMapping(value = "/item/pushitem", method = RequestMethod.GET)
    public ModelAndView getPushItem() {
        ModelAndView model = new ModelAndView("/item/pushItem");
        PushBufferDO pushBufferDO = new PushBufferDO();
        List<PushBufferDO> pushBufferDOs = pushBufferDao.find(pushBufferDO);
        model.addObject("items", pushBufferDOs);
        return model;
    }

    /**
     * 从 带推送列表中 移除商品
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/item/removeitem", method = RequestMethod.GET)
    public ModelAndView removeItemFromBuffer(Long id, Long itemHouseId) {
        pushBufferDao.delete(id);
        ItemHouseDO itemHouseDO = new ItemHouseDO();
        itemHouseDO.setId(itemHouseId);
        itemHouseDO.setIsPush(false);
        itemHouseDao.update(itemHouseDO);
        ModelAndView model = getPushItem();
        return model;
    }


    /**
     * 推送商品到 客户端，客户端刷新后可见新品
     *
     * @return
     */
    @RequestMapping(value = "/item/pushbufferitem", method = RequestMethod.GET)
    public ModelAndView pushBufferItemToClient(Integer categoryId) {
        PushBufferDO pushBufferDO = new PushBufferDO();
        List<PushBufferDO> pushBufferDOs = pushBufferDao.find(pushBufferDO);
        //创建推送记录
        Date now = new Date();
        PushOptDO pushOptDO = new PushOptDO();
        pushOptDO.setItemCount(pushBufferDOs.size());
        pushOptDO.setPushTime(now);
        Integer pushOptId = pushOptDao.create(pushOptDO);
        for (int i = 0; i < pushBufferDOs.size(); i++) {
            PushedItemDO pushedItemDO = new PushedItemDO();
            pushedItemDO.setPushTime(now);
            pushedItemDO.setPushOptId(pushOptId);
            pushedItemDO.setPicUrl(pushBufferDOs.get(i).getPicUrl());
            pushedItemDO.setPrice(pushBufferDOs.get(i).getPrice());
            pushedItemDO.setTitle(pushBufferDOs.get(i).getTitle());
            pushedItemDO.setCategoryId(categoryId);
            pushedItemDO.setItemHouseId(pushBufferDOs.get(i).getItemHouseId());
            pushedItemDO.setItemId(pushBufferDOs.get(i).getItemId());
            pushedItemDao.create(pushedItemDO);
            pushBufferDao.delete(pushBufferDOs.get(i).getId());
            ItemHouseDO itemHouseDO = new ItemHouseDO();
            itemHouseDO.setId(pushBufferDOs.get(i).getItemHouseId());
            itemHouseDO.setIsPush(false);
            itemHouseDO.setPushTime(now);
            itemHouseDao.update(itemHouseDO);
        }
        ModelAndView model = getPushItem();
        return model;
    }


    /**
     * 获取推送历史，暂且不做分页
     *
     * @return
     */
    @RequestMapping(value = "/item/pushhistory", method = RequestMethod.GET)
    public ModelAndView pushHistory() {
        List<List<PushedItemDO>> history = new ArrayList<List<PushedItemDO>>();
        ModelAndView model = new ModelAndView("/item/pushHistory");
        List<PushOptDO> pushOptDOs = pushOptDao.find("findAllOrderByTimeDesc", null);
        for (int i = 0; i < pushOptDOs.size(); i++) {
            PushedItemDO pushedItemDO = new PushedItemDO();
            pushedItemDO.setPushOptId(pushOptDOs.get(i).getId());
            List<PushedItemDO> pushs = pushedItemDao.find(pushedItemDO);
            history.add(pushs);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        model.addObject("dateFormat", dateFormat);
        model.addObject("timeFormat", timeFormat);
        model.addObject("history", history);
        return model;
    }

}

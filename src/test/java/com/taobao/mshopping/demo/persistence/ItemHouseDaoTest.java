package com.taobao.mshopping.demo.persistence;

import com.taobao.mshopping.demo.model.ItemHouseDO;
import org.junit.Test;

/**
 * Created by xinyuan on 14/6/23.
 */
public class ItemHouseDaoTest extends BaseTestCase {

    @Test
    public void testCreate() throws Exception {
        ItemHouseDO itemHouseDO = new ItemHouseDO();
        itemHouseDO.setItemId(19360435647L);
        itemHouseDO.setPic("http://img03.taobaocdn.com/bao/uploaded/i3/19619022379639634/T1ih8JXDReXXXXXXXX_!!0-item_pic.jpg");
        itemHouseDO.setPrice(22.00);
        itemHouseDO.setIsPush(false);
        itemHouseDao.create(itemHouseDO);
    }
}

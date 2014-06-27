package com.taobao.mshopping.demo.persistence;

import com.taobao.itest.ITestSpringContextBaseCase;
import com.taobao.itest.annotation.ITestSpringContext;
import com.taobao.mshopping.demo.persistence.dao.ItemHouseDao;

import javax.annotation.Resource;

/**
 * Created by xinyuan on 14/6/23.
 */
@ITestSpringContext(value = "/ibatis/mshopping-dao.xml")
public class BaseTestCase extends ITestSpringContextBaseCase{

    @Resource
    ItemHouseDao itemHouseDao;

}

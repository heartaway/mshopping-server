package com.taobao.mshopping.demo.persistence;

import com.taobao.itest.ITestSpringContextBaseCase;
import com.taobao.itest.annotation.ITestSpringContext;
import com.taobao.mshopping.demo.persistence.dao.ItemHouseDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by xinyuan on 14/6/23.
 */
@ITestSpringContext(value = "/ibatis/mshopping-dao.xml")
public class BaseTestCase extends ITestSpringContextBaseCase{

    @Resource
    ItemHouseDao itemHouseDao;

    final static Logger logger = LoggerFactory.getLogger(BaseTestCase.class);



}

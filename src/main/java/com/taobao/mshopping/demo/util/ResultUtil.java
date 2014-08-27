package com.taobao.mshopping.demo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * mulou.zzy
 * taedemo
 */
public class ResultUtil {


    public final static Map<String, Object> genSuccessResult() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        return map;

    }

    public final static Map<String, Object> genSuccessResult(Object data) {
        Map<String, Object> map = genSuccessResult();
        map.put("data", data);
        return map;

    }

    public final static Map<String, Object> genFailedResult(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", -200);
        map.put("msg", msg);
        return map;

    }
}

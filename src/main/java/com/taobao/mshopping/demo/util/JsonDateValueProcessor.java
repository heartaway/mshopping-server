package com.taobao.mshopping.demo.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.util.Date;

/**
 * Created by xinyuan on 14/6/26.
 */
public class JsonDateValueProcessor implements JsonValueProcessor {

    private String format ="yyyy-MM-dd HH:mm:ss";

    public Object processArrayValue(Object value, JsonConfig config) {
        return process(value);
    }

    public Object processObjectValue(String key, Object value, JsonConfig config) {
        return process(value);
    }

    private Object process(Object value){

        if(value instanceof Date){
            return ((Date) value).getTime();
        }
        return value == null ? "" : value.toString();
    }
}

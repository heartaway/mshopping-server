package com.taobao.mshopping.demo.openapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by huamulou on 14-8-29.
 */


@Controller
public class Test {


    @ResponseBody
    @RequestMapping(value = "/test/{a}/{b}/{c}")
    public String getCreateOrderByPost(
            @PathVariable String a,
            @PathVariable String b,
            @PathVariable String c
    ) {
        return a + "-" + b + "-" + c;
    }
}

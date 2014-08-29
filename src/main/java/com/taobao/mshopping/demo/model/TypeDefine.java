package com.taobao.mshopping.demo.model;

/**
 * Created by huamulou on 14-8-29.
 */
public enum TypeDefine {


    NORMAL(0), LOCAL(1);

    public int value;


     TypeDefine(int value) {
        this.value = value;
    }


    public static TypeDefine valueOf(int i) {
        switch (i) {
            case 0:
                return NORMAL;

            case 1:
                return LOCAL;
            default:
                return NORMAL;


        }


    }


}

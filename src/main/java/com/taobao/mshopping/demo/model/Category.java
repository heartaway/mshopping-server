package com.taobao.mshopping.demo.model;

/**
 * Created by xinyuan on 14/6/26.
 */
public enum Category {

    NEW(1,"最新"),
    SELECT(2,"精选"),
    FASHION(3,"时尚");

    private int category;
    private String description;

    Category(int category, String description) {
        this.category = category;
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}

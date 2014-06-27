package com.taobao.mshopping.demo.model;

import java.util.Date;

/**
 * Created by xinyuan on 14/6/23.
 */
public class PushBufferDO {


    private Long id;
    /*商品ID*/
    private Long itemId;
    /*录入到系统中的商品的主键*/
    private Long itemHouseId;
    /*商品主图*/
    private String picUrl;
    private String title;
    private Double price;
    private Date gmtCreate;
    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getItemHouseId() {
        return itemHouseId;
    }

    public void setItemHouseId(Long itemHouseId) {
        this.itemHouseId = itemHouseId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}

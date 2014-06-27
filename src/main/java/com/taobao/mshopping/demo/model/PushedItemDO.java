package com.taobao.mshopping.demo.model;

import java.util.Date;

/**
 * Created by xinyuan on 14/6/23.
 */
public class PushedItemDO {

    private Long id;
    /*商品ID*/
    private Long itemId;
    /*商品主图*/
    private String picUrl;
    /*商品价格*/
    private Double price;
    /*商品标题*/
    private String title;
    /*商品分类：最新、精选、时尚*/
    private Integer categoryId;

    /*录入到系统中的商品的主键*/
    private Long itemHouseId;
    /*推送操作号*/
    private Integer pushOptId;
    /*推送时间*/
    private Date pushTime;

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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Long getItemHouseId() {
        return itemHouseId;
    }

    public void setItemHouseId(Long itemHouseId) {
        this.itemHouseId = itemHouseId;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Integer getPushOptId() {
        return pushOptId;
    }

    public void setPushOptId(Integer pushOptId) {
        this.pushOptId = pushOptId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

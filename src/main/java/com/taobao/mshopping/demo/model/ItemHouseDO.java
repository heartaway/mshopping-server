package com.taobao.mshopping.demo.model;

import java.util.Date;

/**
 * Created by xinyuan on 14/6/23.
 */
public class ItemHouseDO {

    private Long id;
    /*商品ID*/
    private Long itemId;
    /*商品标题*/
    private String title;
    /*商品价格*/
    private Double price;
    /*商品主图*/
    private String pic;
    /*商品是否已被推送到客户端*/
    private Boolean isPush;
    /*商品被推送时间，如果未推送为null*/
    private Date pushTime;

    private Date gmtCreate;
    private Date gmtModified;

    private Integer type;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Boolean getIsPush() {
        return isPush;
    }

    public void setIsPush(Boolean isPush) {
        this.isPush = isPush;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
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


    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}

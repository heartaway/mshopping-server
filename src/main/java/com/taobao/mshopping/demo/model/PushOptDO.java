package com.taobao.mshopping.demo.model;

import java.util.Date;

/**
 * Created by xinyuan on 14/6/23.
 */
public class PushOptDO {

    /*本次推送的商品编号*/
    private Integer id;
    /*本次推送的时间*/
    private Date pushTime;
    /*本次推送的商品数量*/
    private Integer itemCount;

    private Date gmtCreate;
    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
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

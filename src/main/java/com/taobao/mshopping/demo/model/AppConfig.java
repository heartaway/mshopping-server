package com.taobao.mshopping.demo.model;

/**
 * 应用的配置信息
 * mulou.zzy
 * taedemo
 */
public class AppConfig {


    private String appKey;
    private String appSecret;


    private boolean isLocal;


    private String dataSourceAlias;


    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public void setLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setDataSourceAlias(String dataSourceAlias) {
        this.dataSourceAlias = dataSourceAlias;
    }

    public String getDataSourceAlias() {
        return dataSourceAlias;
    }
}

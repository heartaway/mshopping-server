package com.taobao.mshopping.demo.model;

import com.alibaba.demo.defines.Env;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用的配置信息
 * mulou.zzy
 * taedemo
 */
public class AppConfig {


    private String appKey;
    private String appSecret;

    private Env env;

    private boolean isLocal;

    private String owner;

    private List<String> ownerList;

    //这个用于本地部署的时候，由于jae tomcat只支持一级目录，可以设置下一级目录叫什么
    private String contextName;

    private boolean isOauth;


    @Override
    public String toString() {
        return "AppConfig{" +
                "appKey='" + appKey + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", env=" + env +
                ", isLocal=" + isLocal +
                ", owner='" + owner + '\'' +
                ", ownerList=" + ownerList +
                ", contextName='" + contextName + '\'' +
                ", isOauth=" + isOauth +
                ", dataSourceAlias='" + dataSourceAlias + '\'' +
                '}';
    }

    private String dataSourceAlias;


    public void setOauth(boolean isOauth) {
        this.isOauth = isOauth;
    }

    public boolean isOauth() {
        return isOauth;
    }

    public AppConfig() {
    }

    public AppConfig(String appKey, String appSecret, Env env) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.env = env;
    }

    public AppConfig(String appKey, String appSecret, Env env, boolean isLocal) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.env = env;
        this.isLocal = isLocal;
    }

    public void setLocal(boolean isLocal) {

        this.isLocal = isLocal;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    public void setEnvValue(int env) {
        this.env = Env.valueOf(env);
    }

    public String getAppKey() {
        return appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public Env getEnv() {
        return env;
    }

    public AppConfig(String appKey, String appSecret, Env env, boolean isLocal, String owner) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.env = env;
        this.isLocal = isLocal;
        this.owner = owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;

        if (StringUtils.isNotBlank(owner)) {
            this.ownerList = new ArrayList<String>();
            for (String o : owner.split(",")) {
                ownerList.add(o);
            }
        }

    }

    public String getOwner() {
        return owner;
    }

    public void setContextName(String contextName) {
        this.contextName = contextName;
    }

    public String getContextName() {
        return contextName;
    }


    public List<String> getOwnerList() {
        return ownerList;
    }


    public void setDataSourceAlias(String dataSourceAlias) {
        this.dataSourceAlias = dataSourceAlias;
    }

    public String getDataSourceAlias() {
        return dataSourceAlias;
    }
}

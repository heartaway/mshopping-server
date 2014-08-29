package com.taobao.mshopping.demo.persistence;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * mulou.zzy
 * taedemo
 */
public class LocalDbConfig {

    static Logger logger = LoggerFactory.getLogger(LocalDbConfig.class);
    private String ip;
    private String port;
    private String db;
    private String user;
    private String password;


    public void setDb(String db) {
        this.db = db;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public String getDb() {
        return db;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    private static Properties extendedProperties = new Properties();


    public static LocalDbConfig getInstance() throws Exception {
        LocalDbConfig localDbConfig = new LocalDbConfig();
        //从类路径加载配置文件
        InputStream is = LocalDbConfig.class.getClassLoader().getResourceAsStream("localdb.properties");
        if (is == null) {
            logger.warn("no apns.properties in classpath");
            //如果加载不到就从jar包路径加载
        } else {
            extendedProperties.load(is);
        }

        if (extendedProperties != null) {
            getConfig(extendedProperties, localDbConfig);
            return localDbConfig;

        }
        return null;
    }

    private static void getConfig(Properties properties, LocalDbConfig localDbConfig) throws Exception {
        BeanUtils.copyProperties(localDbConfig, properties);
    }

}

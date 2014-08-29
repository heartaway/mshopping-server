package com.taobao.mshopping.demo.persistence;

import com.taobao.mshopping.demo.model.AppConfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.FactoryBean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * mulou.zzy
 * taedemo
 */
public class DataSourceFactory implements FactoryBean<DataSource> {



    private DataSource dataSource;

    Lock lock = new ReentrantLock();


    @Resource
    AppConfig appConfig;

    public void setAppConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }


    @Override
    public DataSource getObject() throws Exception {
        if (dataSource != null) {
            return dataSource;
        } else {
            lock.lock();
            try {
                if (dataSource == null) {
                    if (appConfig.isLocal()) {
                        LocalDbConfig localDbConfig = LocalDbConfig.getInstance();
                        BasicDataSource basicDataSource = new BasicDataSource();
                        basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
                        basicDataSource.setUrl("jdbc:mysql://" + localDbConfig.getIp() + ":" + localDbConfig.getPort() + "/" + localDbConfig.getDb() + "?useUnicode=true&characterEncoding=UTF-8");

                        basicDataSource.setUsername(localDbConfig.getUser());
                        basicDataSource.setPassword(localDbConfig.getPassword());

                        basicDataSource.setInitialSize(1);
                        basicDataSource.setMaxActive(50);
                        basicDataSource.setMaxIdle(2);
                        basicDataSource.setMinIdle(1);
                        basicDataSource.getConnection();
                        dataSource = basicDataSource;

                        if (localDbConfig == null) {
                            throw new Exception("can't init");
                        }
                    } else {
                        if (appConfig != null && StringUtils.isNotBlank(appConfig.getDataSourceAlias())) {
                            dataSource = com.alibaba.appengine.api.ds.DataSourceFactory.getDataSource(appConfig.getDataSourceAlias());
                        } else {
                            dataSource = com.alibaba.appengine.api.ds.DataSourceFactory.getDataSource();
                        }
                    }
                }
            } finally {
                lock.unlock();
            }
        }
        return dataSource;
    }

    @Override
    public Class<?> getObjectType() {
        return DataSource.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

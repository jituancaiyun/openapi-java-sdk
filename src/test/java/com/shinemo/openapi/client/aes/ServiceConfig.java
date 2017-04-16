package com.shinemo.openapi.client.aes;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.shinemo.openapi.client.common.OpenApiException;

import javax.sql.DataSource;

/**
 * Created by yuanjian on 4/14/17.
 */
public final class ServiceConfig {
    public static DataSource configDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/shinemo");
            ds.setUser("root");
            ds.setPassword("zjsuweixin");
            ds.setMaxPoolSize(20);
            ds.setInitialPoolSize(10);
            ds.setMaxIdleTime(2000);
        }catch(Exception e){
            throw new OpenApiException("数据源报错");
        }
        return ds;
    }
}

package com.agorafob.dbconnect;

import com.agorafob.util.AppConfig;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolDbConnectionBuilder implements DbConnectionBuilder {
    private final BasicDataSource dataSource;

    public PoolDbConnectionBuilder() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(AppConfig.getProperty("db.driver"));
        dataSource.setUrl(AppConfig.getProperty("db.url"));
        dataSource.setUsername(AppConfig.getProperty("db.login"));
        dataSource.setPassword(AppConfig.getProperty("db.password"));
        dataSource.setMinIdle(5);
        dataSource.setInitialSize(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

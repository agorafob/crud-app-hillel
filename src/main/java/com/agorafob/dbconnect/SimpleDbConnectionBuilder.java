package com.agorafob.dbconnect;

import com.agorafob.util.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleDbConnectionBuilder implements DbConnectionBuilder{
    public SimpleDbConnectionBuilder() {
        try {
            Class.forName(AppConfig.getProperty("db.driver"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(AppConfig.getProperty("db.url"),
                AppConfig.getProperty("db.login"),AppConfig.getProperty("db.password"));
    }
}

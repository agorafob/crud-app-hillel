package com.agorafob.dbconnect;

public class ConnectionBuilderFactory {

    public static DbConnectionBuilder getConnectionBuilder(){
        return new SimpleDbConnectionBuilder();
    }
}

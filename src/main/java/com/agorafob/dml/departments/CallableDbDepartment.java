package com.agorafob.dml.departments;

import com.agorafob.dbconnect.ConnectionBuilderFactory;
import com.agorafob.dbconnect.DbConnectionBuilder;
import com.agorafob.dbconnect.SimpleDbConnectionBuilder;

import java.sql.*;

public class CallableDbDepartment {
    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getConnectionBuilder();


    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    public void doExecute(){
        try (Connection con = getConnection();
             CallableStatement stmt = con.prepareCall("{call getdepartmentbyid(?,?)}"))
        {
            stmt.setInt(1,3);
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.execute();
            String departmentName = stmt.getString(2);
            System.out.println(departmentName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

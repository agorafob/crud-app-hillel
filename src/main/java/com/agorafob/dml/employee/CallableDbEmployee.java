package com.agorafob.dml.employee;

import com.agorafob.dbconnect.ConnectionBuilderFactory;
import com.agorafob.dbconnect.DbConnectionBuilder;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableDbEmployee {
    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    public void doExecute() {
        try (
                Connection con = getConnection();
                CallableStatement stmt = con.prepareCall("{call getnamebyid(?,?)}"))
        {
            stmt.setInt(1, 22);
            stmt.registerOutParameter(2, Types.VARCHAR);

            boolean test = stmt.execute();
            String name = stmt.getString(2);
            System.out.println(test + " ----- " + name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

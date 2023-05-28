package com.agorafob.main.employee;

import com.agorafob.model.Employee;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        String login = "postgres";
        String password = "admin";
        String url = "jdbc:postgresql://localhost:5433/myjavadb";


        try( Connection con = DriverManager.getConnection(url,login,password)){
            System.out.println("Connection got");
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(
                        rs.getLong("id") + " "+
                        rs.getString("name")+ " "+
                        rs.getInt("salary") + " "+
                        rs.getLong("department_id")+" "+
                        rs.getLong("chief_id")

                );

            }
        } catch (SQLException e){
        e.printStackTrace();
    }

}
}

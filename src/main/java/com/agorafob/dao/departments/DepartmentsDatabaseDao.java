package com.agorafob.dao.departments;

import com.agorafob.dbconnect.ConnectionBuilderFactory;
import com.agorafob.dbconnect.DbConnectionBuilder;
import com.agorafob.model.Department;

import static com.agorafob.util.AppConstants.COLUMN_ID;
import static com.agorafob.util.AppConstants.COLUMN_NAME;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDatabaseDao implements DepartmentDao{
    private static final String SELECT = "SELECT * FROM department";
    private static final String GET_DEPARTMENT = "SELECT * FROM department WHERE id = ?";
    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }


    @Override
    public Long addDepartment(Department department) {
        return null;
    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public void deleteDepartment(Long id) {

    }

    @Override
    public Department getDepartment(Long id) {
        Department temp = null;
        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(GET_DEPARTMENT)){
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                 temp = new Department(rs.getLong(COLUMN_ID),rs.getString(COLUMN_NAME));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }

    @Override
    public List<Department> findDepartments() {
        List<Department> departmentList = new ArrayList<>();
        try (Connection con = getConnection(); Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()){
                Department temp = new Department(rs.getLong(COLUMN_ID),rs.getString(COLUMN_NAME));
                departmentList.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return departmentList;
    }
}

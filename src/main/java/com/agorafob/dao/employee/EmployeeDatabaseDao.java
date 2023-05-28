package com.agorafob.dao.employee;

import com.agorafob.dbconnect.ConnectionBuilderFactory;
import com.agorafob.dbconnect.DbConnectionBuilder;
import com.agorafob.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.agorafob.util.AppConstants.COLUMN_ID;
import static com.agorafob.util.AppConstants.COLUMN_NAME;
import static com.agorafob.util.AppConstants.COLUMN_SALARY;
import static com.agorafob.util.AppConstants.COLUMN_DEPARTMENT_ID;
import static com.agorafob.util.AppConstants.COLUMN_CHIEF_ID;

public class EmployeeDatabaseDao implements EmployeeDao {
    private static final String SELECT = "SELECT * FROM employee";
    private static final String GET_EMPLOYEE = "SELECT * FROM employee WHERE id = ?";
    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getConnectionBuilder();


    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    @Override
    public Long addEmployee(Employee employee) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public Employee getEmployee(Long id) {
        Employee temp = null;
        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(GET_EMPLOYEE)) {
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Long chief_id = rs.getLong(COLUMN_CHIEF_ID);
                if(rs.wasNull()){
                    chief_id=null;
                }
                temp = new Employee(rs.getLong(COLUMN_ID),
                        rs.getString(COLUMN_NAME),
                        rs.getInt(COLUMN_SALARY),
                        rs.getLong(COLUMN_DEPARTMENT_ID),
                        chief_id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }

    @Override
    public List<Employee> findEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection con = getConnection(); Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(SELECT);
            while (rs.next()) {
                Long chief_id = rs.getLong(COLUMN_CHIEF_ID);
                if(rs.wasNull()){
                    chief_id=null;
                }

                Employee temp = new Employee(rs.getLong(COLUMN_ID),
                        rs.getString(COLUMN_NAME),
                        rs.getInt(COLUMN_SALARY),
                        rs.getLong(COLUMN_DEPARTMENT_ID),
                        chief_id);
                employeeList.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }
}

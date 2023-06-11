package com.agorafob.dml.employee;

import com.agorafob.dbconnect.ConnectionBuilderFactory;
import com.agorafob.dbconnect.DbConnectionBuilder;
import com.agorafob.model.Employee;

import java.sql.*;
import java.util.Objects;

import static com.agorafob.util.AppConstants.COLUMN_ID;

public class InsertTransactionDbEmployee {
    private static final String INSERT = "INSERT INTO employee(name, salary, department_id, chief_id) VALUES (?, ?, ?, ?)";
    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    public void doTransactionInsert() {
        try (
                Connection con = getConnection();
        ) {
            con.setAutoCommit(false);
            System.out.println(
                    insert(new Employee("Иванов Иван Иванович", 100_000, 1L, null), con)
            );
            System.out.println(
                    insert(new Employee("Степанов Степан Степанович", 100_000, 1L, null), con)
            );
            System.out.println(
                    insert(new Employee("Горбунков Григорий Иванович", 100_000, 1L, null), con)
            );
            System.out.println(
                    insert(new Employee("Сидоров Снанислав Игорьевич", 100_000, 1L, null), con)
            );
            con.commit();
//            con.rollback();
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Long insert(Employee employee, Connection con) throws SQLException {
        // Объявили переменную для хранения ИД
        long employeeId = -1L;

        // Вторым параметром передаем массив полей, значения которых нам нужны
        PreparedStatement stmt = con.prepareStatement(INSERT, new String[]{COLUMN_ID});
        stmt.setString(1, employee.getName());
        stmt.setInt(2, employee.getSalary());
        stmt.setLong(3, employee.getDepartmentId());
        if (Objects.isNull(employee.getChiefId())) {
            stmt.setNull(4, Types.NULL);
        } else {
            stmt.setLong(4, employee.getChiefId());
        }
        stmt.executeUpdate();

        // Получаем список данных дял сгенерированных ключей
        ResultSet gk = stmt.getGeneratedKeys();
        if (gk.next()) {
            // Получаем поле id
            employeeId = gk.getLong(COLUMN_ID);
        }
        stmt.close();

        return employeeId;
    }
}

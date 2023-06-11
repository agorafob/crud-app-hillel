package com.agorafob.dml.employee;

import com.agorafob.dbconnect.ConnectionBuilderFactory;
import com.agorafob.dbconnect.DbConnectionBuilder;
import com.agorafob.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.agorafob.util.AppConstants.COLUMN_ID;

public class InsertBatchDbEmployee {
    private static final String INSERT = "INSERT INTO employee(name, salary, department_id, chief_id) VALUES (?, ?, ?, ?)";
    private final DbConnectionBuilder builder = ConnectionBuilderFactory.getConnectionBuilder();

    private Connection getConnection() throws SQLException {
        return builder.getConnection();
    }

    public void addBatch() {
        List<Employee> employeeList = new ArrayList<>();
        List<Long> chiefIds = null;

        employeeList.add(new Employee("Назаров Максим Давидович", 35000, 1L, null));
        employeeList.add(new Employee("Волков Станислав Юрьевич", 45000, 2L, null));
        employeeList.add(new Employee("Лебедева Анна Михайловна", 20000, 3L, null));
        employeeList.add(new Employee("Колесникова Милана Родионовна", 35000, 4L, null));

        chiefIds = insertBatch(employeeList);

        if (Objects.nonNull(chiefIds)) {
            employeeList.clear();
            employeeList.add(new Employee("Александрова Аиша Игоревна", 5000, 1L, chiefIds.get(0)));
            employeeList.add(new Employee("Кузьмин Артём Богданович", 5500, 1L, chiefIds.get(0)));
            employeeList.add(new Employee("Громова Сафия Владимировна", 6000, 1L, chiefIds.get(0)));
            employeeList.add(new Employee("Еремин Ярослав Тимурович", 6000, 1L, chiefIds.get(0)));
            employeeList.add(new Employee("Баранов Дмитрий Русланович", 5200, 1L, chiefIds.get(0)));
            employeeList.add(new Employee("Еремина София Макаровна", 6500, 1L, chiefIds.get(0)));
            employeeList.add(new Employee("Михайлов Филипп Фёдорович", 15500, 2L, chiefIds.get(1)));
            employeeList.add(new Employee("Макаров Алексей Родионович", 15000, 2L, chiefIds.get(1)));
            employeeList.add(new Employee("Тарасова Юлия Глебовна", 22000, 3L, chiefIds.get(2)));
            employeeList.add(new Employee("Колосова Алиса Константиновна", 18000, 3L, chiefIds.get(2)));
            employeeList.add(new Employee("Сафонов Арсений Егорович", 15000, 3L, chiefIds.get(2)));
            employeeList.add(new Employee("Ларина Ирина Львовна", 15000, 3L, chiefIds.get(2)));
            employeeList.add(new Employee("Пономарева Евгения Данильевна", 15000, 3L, chiefIds.get(2)));
            employeeList.add(new Employee("Журавлева Милана Фёдоровна", 14000, 3L, chiefIds.get(2)));
            employeeList.add(new Employee("Никифоров Максим Максимович", 14500, 3L, chiefIds.get(2)));
            employeeList.add(new Employee("Макаров Алексей Родионович", 15000, 3L, chiefIds.get(2)));
            employeeList.add(new Employee("Куприянова Евгения Даниловна", 12000, 4L, chiefIds.get(3)));
            employeeList.add(new Employee("Чистяков Владимир Артёмович", 13000, 4L, chiefIds.get(3)));
            employeeList.add(new Employee("Савицкая София Андреевна", 15000, 4L, chiefIds.get(3)));
            employeeList.add(new Employee("Борисова Анна Саввична", 37000, 4L, chiefIds.get(3)));
            employeeList.add(new Employee("Греков Артём Маркович", 17000, 4L, chiefIds.get(3)));
        }

        List<Long> ids = insertBatch(employeeList);
        System.out.println("Inserted ids:");
        for (Long id : ids) {
            System.out.println(id);
        }
    }

    public List<Long> insertBatch(List<Employee> employees) {
        // Объявили переменную для хранения ИД
        List<Long> ids = new ArrayList<>();

        // Вторым параметром prepareStatement передаем массив полей, значения которых нам нужны
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        ) {
            for (Employee employee : employees) {
                stmt.setString(1, employee.getName());
                stmt.setInt(2, employee.getSalary());
                stmt.setLong(3, employee.getDepartmentId());
                if (Objects.isNull(employee.getChiefId())) {
                    stmt.setNull(4, Types.NULL);
                } else {
                    stmt.setLong(4, employee.getChiefId());
                }
                // Запрос не выполняется, а укладывается в буфер, кторый выполняется сразу для всех команд
                stmt.addBatch();
            }
            // Выполняем все запросы разом
            stmt.executeBatch();

            // Получаем список данных для сгенерированных ключей
            ResultSet gk = stmt.getGeneratedKeys();
            while (gk.next()) {
                // Получаем поле id
                Long id = gk.getLong(COLUMN_ID);
                ids.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ids;
    }
}

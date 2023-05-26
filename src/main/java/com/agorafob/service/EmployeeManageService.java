package com.agorafob.service;

import com.agorafob.dao.EmployeeDao;
import com.agorafob.dao.EmployeeDaoFactory;
import com.agorafob.model.Employee;

import java.util.List;

public class EmployeeManageService {
    private final EmployeeDao employeeDao;

    public EmployeeManageService() {
        this.employeeDao = EmployeeDaoFactory.getInstance().getEmployeeDao();
    }

    public Long add(Employee employee)  {
        Long id = employeeDao.addEmployee(employee);
        return id;
    }

    public void delete(Long id){
        employeeDao.deleteEmployee(id);
    }

    public Employee get(Long id) {
        return employeeDao.getEmployee(id);
    }

    public void update(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public List<Employee> findAll()  {
        return employeeDao.findEmployees();
    }
}

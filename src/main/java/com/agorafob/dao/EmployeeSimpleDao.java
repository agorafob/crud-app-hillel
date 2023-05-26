package com.agorafob.dao;

import com.agorafob.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeSimpleDao implements EmployeeDao {
    private List<Employee> employeeList = new ArrayList<>();
    private long idCounter = 0;

    @Override
    public Long addEmployee(Employee employee) {
//        long employeeId = getEmployeeId();
//        employee.setId(employeeId);
        employee.setId(++idCounter);
        employeeList.add(employee);
//        return employeeId;
        return idCounter;
    }

    @Override
    public void updateEmployee(Employee employee) {
        for (Employee e:employeeList ) {
            if(Objects.equals(e.getId(), employee.getId())){
                e.setName(employee.getName());
                e.setSalary(employee.getSalary());
                e.setDepartmentId(employee.getDepartmentId());
                e.setChiefId(employee.getChiefId());
                break;
            }
        }

    }

    @Override
    public void deleteEmployee(Long id) {
        for (Employee e:employeeList ) {
            if(Objects.equals(e.getId(), id)){
                employeeList.remove(e);
                break;
            }
        }
    }

    @Override
    public Employee getEmployee(Long id) {
        Employee employeeToReturn = null;
        for (Employee e:employeeList ) {
            if(Objects.equals(e.getId(), id)){
                employeeToReturn=e;
            }
        }
        return employeeToReturn;
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeList;
    }


    private long getEmployeeId() {
        long id = Math.round(Math.random()*1000) + System.currentTimeMillis();
        while (Objects.nonNull(getEmployee(id))){
            id= Math.round(Math.random()*1000) + System.currentTimeMillis();
        }
        return id;
    }
}

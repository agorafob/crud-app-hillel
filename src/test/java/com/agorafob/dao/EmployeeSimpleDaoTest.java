package com.agorafob.dao;

import com.agorafob.model.Employee;
import com.agorafob.service.EmployeeManageService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeSimpleDaoTest {

    @Test
    void addEmployee() {
        Employee test = new Employee("test",10,10L,10L);
        EmployeeManageService ems = new EmployeeManageService();
       assertEquals(1,ems.add(test));
    }

    @Test
    void updateEmployee() {
        Employee test = new Employee("test",10,10L,10L);
        EmployeeManageService ems = new EmployeeManageService();
        ems.add(test);
        Employee test2 = ems.get(1L);
        test2.setSalary(100000);
        ems.update(test2);
        assertEquals(test2,ems.get(1L));
    }

    @Test
    void deleteEmployee() {
        Employee test = new Employee("test",10,10L,10L);
        Employee test2 = new Employee("test2",20,20L,20L);
        EmployeeManageService ems = new EmployeeManageService();
        ems.add(test);
        ems.add(test2);
        ems.delete(2L);
        assertNull(ems.get(2L));
    }

    @Test
    void getEmployee() {
        Employee test = new Employee("test",10,10L,10L);
        EmployeeManageService ems = new EmployeeManageService();
        ems.add(test);
        assertEquals(test,ems.get(1L));
    }

    @Test
    void findEmployees() {
        Employee test = new Employee("test",10,10L,10L);
        Employee test2 = new Employee("test2",20,20L,20L);
        EmployeeManageService ems = new EmployeeManageService();
        ems.add(test);
        ems.add(test2);
        List<Employee> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test2);
        assertEquals(testList,ems.findAll());

    }
}
package com.agorafob.main.employee;

import com.agorafob.model.Employee;
import com.agorafob.service.EmployeeManageService;
import com.agorafob.util.AppConfig;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class EmployeeDbMain {
    public static void main(String[] args) throws URISyntaxException, IOException {
        AppConfig.initAppConfig();
        EmployeeManageService ems = new EmployeeManageService();
//        List<Employee> print = ems.findAll();
//        for (Employee e:print) {
//            System.out.println(e);
//        }
        Employee e = ems.get(10L);
        System.out.println(e);
    }
}

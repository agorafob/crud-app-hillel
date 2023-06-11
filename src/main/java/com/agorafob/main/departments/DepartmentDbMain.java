package com.agorafob.main.departments;

import com.agorafob.model.Department;
import com.agorafob.service.DepartmentManagerService;
import com.agorafob.util.AppConfig;

import java.io.IOException;
import java.net.URISyntaxException;

public class DepartmentDbMain {
    public static void main(String[] args) throws URISyntaxException, IOException {
        AppConfig.initAppConfig();
        DepartmentManagerService dms = new DepartmentManagerService();
//        for (Department d: dms.findDepartments()) {
//            System.out.println(d);
//        }

//        System.out.println(dms.getDepartment(5L));
//        Department department = new Department("test");
//        dms.addDepartment(department);
//        dms.updateDepartment(new Department(7L,"testtesttest"));
        dms.deleteDepartment(7L);
    }
}

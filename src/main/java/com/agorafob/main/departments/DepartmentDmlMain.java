package com.agorafob.main.departments;

import com.agorafob.dml.departments.CallableDbDepartment;
import com.agorafob.util.AppConfig;

import java.io.IOException;
import java.net.URISyntaxException;

public class DepartmentDmlMain {
    public static void main(String[] args) throws URISyntaxException, IOException {
        AppConfig.initAppConfig();

        CallableDbDepartment call = new CallableDbDepartment();
        call.doExecute();
    }
}

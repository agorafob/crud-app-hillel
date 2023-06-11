package com.agorafob.main.employee;

import com.agorafob.dml.employee.InsertTransactionDbEmployee;
import com.agorafob.util.AppConfig;

import java.io.IOException;
import java.net.URISyntaxException;

public class EmployeeDmlMain {
    public static void main(String[] args) throws URISyntaxException, IOException {
        AppConfig.initAppConfig();

//        CallableDbEmployee callableDb = new CallableDbEmployee();
//        callableDb.doExecute();
        InsertTransactionDbEmployee ins = new InsertTransactionDbEmployee();
        ins.doTransactionInsert();
    }
}

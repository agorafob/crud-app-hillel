package com.agorafob;

import com.agorafob.model.Employee;
import com.agorafob.service.EmployeeManageService;

import java.util.List;

public class EmployeeSimpleMain {
    public static void main(String[] args) {
        EmployeeManageService ems = new EmployeeManageService();
        //department1
        Employee e1 = new Employee("Назаров Максим Давидович", 35000, 1L, null);
        Long dept1ChiefId = ems.add(e1);
        Employee e2 = new Employee("Александрова Аиша Игоревна", 5000, 1L, dept1ChiefId);
        Employee e3 = new Employee("Кузьмин Артём Богданович", 5000, 1L, dept1ChiefId);
        Employee e4 = new Employee("Громова Сафия Владимировна", 6000, 1L, dept1ChiefId);
        Employee e5 = new Employee("Еремин Ярослав Тимурович", 6000, 1L, dept1ChiefId);
        Employee e6 = new Employee("Баранов Дмитрий Русланович", 5200, 1L, dept1ChiefId);
        Employee e7 = new Employee("Еремина София Макаровна", 6500, 1L, dept1ChiefId);
        ems.add(e2);
        ems.add(e3);
        ems.add(e4);
        ems.add(e5);
        ems.add(e6);
        ems.add(e7);
        //department2
        Employee e8 = new Employee("Волков Станислав Юрьевич", 45000, 2L, null);
        Long dept2ChiefId = ems.add(e8);
        Employee e9 = new Employee("Михайлов Филипп Фёдорович", 15500, 2L, dept2ChiefId);
        Employee e10 = new Employee("Макаров Алексей Родионович", 15000, 2L, dept2ChiefId);
        ems.add(e9);
        ems.add(e10);
        //department3
        Employee e11 = new Employee("Лебедева Анна Михайловна", 20000, 3L, null);
        Long dept3ChiefId = ems.add(e11);
        Employee e12 = new Employee("Тарасова Юлия Глебовна", 22000, 3L, dept3ChiefId);
        Employee e13 = new Employee("Колосова Алиса Константиновна", 18000, 3L, dept3ChiefId);
        Employee e14 = new Employee("Сафонов Арсений Егорович", 15000, 3L, dept3ChiefId);
        Employee e15 = new Employee("Ларина Ирина Львовна", 15000, 3L, dept3ChiefId);
        Employee e16 = new Employee("Пономарева Евгения Данильевна", 15000, 3L, dept3ChiefId);
        Employee e17 = new Employee("Журавлева Милана Фёдоровна", 14000, 3L, dept3ChiefId);
        Employee e18 = new Employee("Никифоров Максим Максимович", 14500, 3L, dept3ChiefId);
        Employee e19 = new Employee("Макаров Алексей Родионович", 15000, 3L, dept3ChiefId);
        ems.add(e12);
        ems.add(e13);
        ems.add(e14);
        ems.add(e15);
        ems.add(e16);
        ems.add(e17);
        ems.add(e18);
        ems.add(e19);
        //department4
        Employee e20 = new Employee("Колесникова Милана Родионовна", 35000, 4L, null);
        Long dept4ChiefId = ems.add(e20);
        Employee e21 = new Employee("Куприянова Евгения Даниловна", 12000, 4L, dept4ChiefId);
        Employee e22 = new Employee("Чистяков Владимир Артёмович", 13000, 4L, dept4ChiefId);
        Employee e23 = new Employee("Савицкая София Андреевна", 15000, 4L, dept4ChiefId);
        Employee e24 = new Employee("Борисова Анна Саввична", 37000, 4L, dept4ChiefId);
        Employee e25 = new Employee("Греков Артём Маркович", 17000, 4L, dept4ChiefId);
        ems.add(e21);
        ems.add(e22);
        ems.add(e23);
        ems.add(e24);
        ems.add(e25);

        System.out.println("======================");
        List<Employee> toPrint = ems.findAll();
        for (Employee e:toPrint) {
            System.out.println(e);
        }
        System.out.println("======================");
        Employee toChange = ems.get(3L);
        System.out.println("Employee to change");
        System.out.println(toChange);
        toChange.setSalary(10000000);
        ems.update(toChange);

        ems.delete(12L);
        System.out.println("======================");
        List<Employee> toPrint2 = ems.findAll();
        for (Employee e:toPrint2) {
            System.out.println(e);
        }
        System.out.println("======================");


    }

}

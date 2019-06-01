package com.itacademy.database.dao;

import com.itacademy.database.entity.Employee;

import java.util.List;

public class EmployeeDao implements BaseDao<Long, Employee> {

    private static final EmployeeDao INSTANCE = new EmployeeDao();

    public static EmployeeDao getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employees = employeeDao.findAll();
        System.out.println(employees);

    }
}

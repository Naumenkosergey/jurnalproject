package com.itacademy.database.dao;

import com.itacademy.database.entity.Employee;
import org.hibernate.SessionFactory;

public class EmployeeDao implements BaseDao<Long, Employee> {

    private static final EmployeeDao INSTANCE = new EmployeeDao();

    public static EmployeeDao getInstance() {
        return INSTANCE;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

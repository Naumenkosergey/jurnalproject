package com.itacademy.database.dao;

import com.itacademy.database.entity.Student;
import org.hibernate.SessionFactory;

public class StudentDao implements BaseDao<Long, Student> {

    private static final StudentDao INSTANCE = new StudentDao();

    public static StudentDao getInstance() {
        return INSTANCE;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

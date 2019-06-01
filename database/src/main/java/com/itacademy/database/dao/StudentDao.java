package com.itacademy.database.dao;

import com.itacademy.database.entity.Student;

public class StudentDao implements BaseDao<Long, Student> {

    private static final StudentDao INSTANCE = new StudentDao();

    public static StudentDao getInstance(){
        return INSTANCE;
    }
}

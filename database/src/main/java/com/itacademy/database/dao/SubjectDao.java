package com.itacademy.database.dao;

import com.itacademy.database.entity.Subject;

public class SubjectDao implements BaseDao<Long, Subject> {

    private static final SubjectDao INSTANCE = new SubjectDao();

    public static SubjectDao getInstance(){
        return INSTANCE;
    }
}

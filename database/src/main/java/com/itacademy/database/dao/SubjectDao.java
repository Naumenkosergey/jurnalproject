package com.itacademy.database.dao;

import com.itacademy.database.entity.Subject;
import org.hibernate.SessionFactory;

public class SubjectDao implements BaseDao<Long, Subject> {

    private static final SubjectDao INSTANCE = new SubjectDao();

    public static SubjectDao getInstance() {
        return INSTANCE;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

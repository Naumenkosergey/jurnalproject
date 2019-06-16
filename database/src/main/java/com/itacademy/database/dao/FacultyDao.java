package com.itacademy.database.dao;

import com.itacademy.database.entity.Faculty;
import org.hibernate.SessionFactory;

public class FacultyDao implements BaseDao<Long, Faculty> {

    private static final FacultyDao INSTANCE = new FacultyDao();

    public static FacultyDao getInstance() {
        return INSTANCE;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

package com.itacademy.database.dao;

import com.itacademy.database.entity.Mark;
import org.hibernate.SessionFactory;

public class MarkDao implements BaseDao<Long, Mark> {

    private static final MarkDao INSTANCE = new MarkDao();

    public static MarkDao getInstance() {
        return INSTANCE;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

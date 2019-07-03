package com.itacademy.database.dao;

import com.itacademy.database.entity.Status;
import org.hibernate.SessionFactory;

public class StatusDao implements BaseDao<Long, Status> {

    private static final StatusDao INSTANCE = new StatusDao();

    public static StatusDao getInstance() {
        return INSTANCE;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

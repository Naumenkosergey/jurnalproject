package com.itacademy.database.dao;

import com.itacademy.database.entity.Flow;
import org.hibernate.SessionFactory;

public class FlowDao implements BaseDao<Long, Flow> {

    private static final FlowDao INSTANCE = new FlowDao();

    public static FlowDao getInstance() {
        return INSTANCE;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

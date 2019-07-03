package com.itacademy.database.dao;

import com.itacademy.database.entity.Groupa;
import org.hibernate.SessionFactory;

public class GroupDao implements BaseDao<Long, Groupa> {

    private static final GroupDao INSTANCE = new GroupDao();

    public static GroupDao getInstance() {
        return INSTANCE;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

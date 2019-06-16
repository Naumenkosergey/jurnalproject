package com.itacademy.database.dao;

import com.itacademy.database.entity.Office;
import org.hibernate.SessionFactory;

public class OfficeDao implements BaseDao<Long, Office> {

    private static final OfficeDao INSTANCE = new OfficeDao();

    public static OfficeDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Office> getClazz() {
        return null;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

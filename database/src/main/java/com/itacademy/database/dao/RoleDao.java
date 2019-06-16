package com.itacademy.database.dao;

import com.itacademy.database.entity.Role;
import org.hibernate.SessionFactory;

public class RoleDao implements BaseDao<Long, Role> {

    private static final RoleDao INSTANCE = new RoleDao();

    public static RoleDao getInstance() {
        return INSTANCE;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}

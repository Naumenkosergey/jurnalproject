package com.itacademy.database.dao;

import com.itacademy.database.entity.Role;

public class RoleDao implements BaseDao<Long,Role> {

    private static final RoleDao INSTANCE = new RoleDao();

    public static RoleDao getInstance(){
        return INSTANCE;
    }
}

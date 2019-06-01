package com.itacademy.database.dao;

import com.itacademy.database.entity.Status;

public class StatusDao implements BaseDao<Long,Status> {

    private static final StatusDao INSTANCE = new StatusDao();

    public static  StatusDao getInstance(){
        return INSTANCE;
    }
}

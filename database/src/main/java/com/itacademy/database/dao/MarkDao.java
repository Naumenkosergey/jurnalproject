package com.itacademy.database.dao;

import com.itacademy.database.entity.Mark;

public class MarkDao implements BaseDao<Long,Mark> {

    private static final MarkDao INSTANCE = new MarkDao();

    public static MarkDao getInstance(){
        return INSTANCE;
    }
}

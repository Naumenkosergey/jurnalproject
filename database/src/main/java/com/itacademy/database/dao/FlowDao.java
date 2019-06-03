package com.itacademy.database.dao;

import com.itacademy.database.entity.Flow;

public class FlowDao implements BaseDao<Long, Flow> {

    private static final FlowDao INSTANCE = new FlowDao();

    public static FlowDao getInstance() {
        return INSTANCE;
    }
}

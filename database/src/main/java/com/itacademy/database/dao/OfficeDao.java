package com.itacademy.database.dao;

import com.itacademy.database.entity.Office;

public class OfficeDao implements BaseDao<Long,Office> {

    private static final OfficeDao INSTANCE = new OfficeDao();

    public static OfficeDao getInstance(){
        return INSTANCE;
    }

}

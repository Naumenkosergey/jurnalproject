package com.itacademy.database.dao;

import com.itacademy.database.entity.User;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    public User getDefaultUser(){
        User user = new User();
        user.setId(1L);
        user.setName("Serega");
        return user;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}

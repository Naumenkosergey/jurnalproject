package com.itacademy.service;

import com.itacademy.database.dao.UserDao;
import com.itacademy.database.entity.User;

public class UserService {

    private static final UserService INSANCE = new UserService();
    private final UserDao userDao = UserDao.getInstance();


    public static UserService getInsance() {
        return INSANCE;
    }

    public User getDefaultUser() {
        return userDao.getDefaultUser();
    }
}

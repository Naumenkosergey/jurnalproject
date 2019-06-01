package com.itacademy.database.dao;

import com.itacademy.database.entity.User;

public class UserDao implements BaseDao<Long,User> {

    private static  final UserDao INSTANCE = new UserDao();

    public static UserDao getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        User user = new User().builder()
                .login("wefwefwef")
                .password("wefewewf")
                .build();
        UserDao userDao = getInstance();
//        System.out.println(userDao.findAll());
//        System.out.println(userDao.findById(1L));
        System.out.println(userDao.save(user));
//        userDao.update(user);
    }
}
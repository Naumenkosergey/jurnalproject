package com.itacademy.service;

import com.itacademy.database.dao.IDao;
import com.itacademy.database.dao.UserDaoImpl;
import com.itacademy.database.entity.User;

import java.util.List;

public class UserService implements IService<User> {

    private IDao<User> userDao = new UserDaoImpl();

    @Override
    public User findUser(int id) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }
}

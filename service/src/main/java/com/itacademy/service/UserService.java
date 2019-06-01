package com.itacademy.service;

import com.itacademy.database.dao.UserDao;
import com.itacademy.database.entity.User;
import com.itacademy.database.util.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserService implements IService<User> {

    private static SessionFactory factory = HibernateSessionFactoryUtil.getSessionFactory();

    private final UserDao userDao =UserDao.getInstance();

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

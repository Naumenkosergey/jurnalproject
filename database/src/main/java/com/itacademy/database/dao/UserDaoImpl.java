package com.itacademy.database.dao;

import com.itacademy.database.entity.User;
import com.itacademy.database.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class UserDaoImpl implements IDao<User> {

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users =  (List<User>) session.createQuery("select u from User u").list();
        session.close();
        return users;
    }


    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.findAll());
    }
}
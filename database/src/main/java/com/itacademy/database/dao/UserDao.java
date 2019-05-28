package com.itacademy.database.dao;

import com.itacademy.database.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();


    public List<User> findAll(){
        Session session = FACTORY.openSession();
        List<User> users = session.createQuery("select u from User u", User.class)
                .list();
        return users;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
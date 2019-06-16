package com.itacademy.database.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {

        return sessionFactory;
    }
}

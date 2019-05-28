package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class UserTest {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntityUser() {
        @Cleanup
        Session session = FACTORY.openSession();
        User user = new User().builder()
                .login("login")
                .password("password")
                .build();
        Serializable id = session.save(user);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityLessStudent() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new User().builder()
                .login("login")
                .password("password")
                .build());
        assertNotNull(id);
        User user = session.get(User.class, id);
        assertNotNull(user);
    }
}
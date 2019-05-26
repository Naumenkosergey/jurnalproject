package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class RoleTest {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntityRole() {
        @Cleanup
        Session session = FACTORY.openSession();
        Role role = new Role().builder()
                .name("Админ")
                .build();
        Serializable id = session.save(role);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityLessRole() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Role().builder()
                .name("Студент")
                .build());
        assertNotNull(id);
        Role role = session.get(Role.class, id);
        assertNotNull(role);
    }

}
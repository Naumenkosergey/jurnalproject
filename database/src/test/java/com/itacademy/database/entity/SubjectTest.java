package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class SubjectTest {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntitySubject() {
        @Cleanup
        Session session = FACTORY.openSession();
        Subject subject = new Subject().builder()
                .name("Python")
                .semestr(4)
                .build();
        Serializable id = session.save(subject);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityLessSubject() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Subject().builder()
                .name("LRM")
                .semestr(1)
                .build());
        assertNotNull(id);
        Subject subject = session.get(Subject.class, id);
        assertNotNull(subject);
    }
}
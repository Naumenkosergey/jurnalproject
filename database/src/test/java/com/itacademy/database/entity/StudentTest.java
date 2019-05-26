package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class StudentTest {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntityStudent() {
        @Cleanup
        Session session = FACTORY.openSession();
        Student student = new Student().builder()
                .name("Никита")
                .sername("Тимошенко")
                .patronymich("ffe")
                .build();
        Serializable id = session.save(student);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityLessStudent() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Student().builder()
                .name("Никита")
                .sername("Тимошенко")
                .patronymich("ffe")
                .build());
        assertNotNull(id);
        Student student = session.get(Student.class, id);
        assertNotNull(student);
    }
}
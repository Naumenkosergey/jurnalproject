package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;
import java.time.Instant;

import static org.junit.Assert.assertNotNull;

public class LessonTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntityLesson() {
        @Cleanup
        Session session = FACTORY.openSession();
        Lesson lesson = new Lesson().builder()
                .data(Instant.now())
                .homework("HW1")
                .topick("topick1")
                .build();
        Serializable id = session.save(lesson);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityLesson() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Lesson()
                .builder()
                .data(Instant.now())
                .homework("ДЗ1")
                .topick("Тема1")
                .build());
        assertNotNull(id);
        Lesson lesson = session.get(Lesson.class, id);
        assertNotNull(lesson);
    }


}
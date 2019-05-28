package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class StatusTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntityStatus() {
        try (Session session = FACTORY.openSession()) {
            Status status = new Status().builder()
                    .name("Академ")
                    .build();
            Serializable id = session.save(status);
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetEntityStatus() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Status().builder().name("отчислен").build());
        assertNotNull(id);
        Status status = session.get(Status.class, id);
        System.out.println(status);
        assertNotNull(status);

    }
}
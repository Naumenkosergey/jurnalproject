package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class OfficeTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntityLesson() {
        @Cleanup
        Session session = FACTORY.openSession();
        Office office = new Office().builder()
                .name("Mогилевская")
                .build();
        Serializable id = session.save(office);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityLessOffice() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Office().builder()
                .name("Mогилевская")
                .build());
        assertNotNull(id);
        Office office = session.get(Office.class, id);
        assertNotNull(office);
    }
}
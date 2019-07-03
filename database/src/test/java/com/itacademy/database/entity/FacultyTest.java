package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class FacultyTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntrtyFaculy() {
        @Cleanup
        Session session = FACTORY.openSession();
        Faculty faculty = new Faculty().builder()
                .name("JUN")
                .build();
        Serializable id = session.save(faculty);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityFaculty() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Faculty().builder().name("TEEN").build());
        assertNotNull(id);
        Faculty faculty = session.get(Faculty.class, id);
        assertNotNull(faculty);
    }

}
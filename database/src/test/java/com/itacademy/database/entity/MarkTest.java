package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class MarkTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntityMark() {
        @Cleanup
        Session session = FACTORY.openSession();
        Mark mark = new Mark().builder()
                .value(1)
                .experiance(300)
                .build();
        Serializable id = session.save(mark);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityMark() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Mark()
                .builder()
                .value(2)
                .experiance(100)
                .build());
        assertNotNull(id);
        Mark mark = session.get(Mark.class, id);
        assertNotNull(mark);
    }


}
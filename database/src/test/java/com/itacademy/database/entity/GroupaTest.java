package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class GroupaTest {

    private static SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntityGroupa() {
        @Cleanup
        Session session = FACTORY.openSession();
        Groupa groupa = new Groupa().builder().number(5).semestr(2).build();
        Serializable id = session.save(groupa);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityGroupa() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Groupa().builder().number(4).semestr(1).build());
        assertNotNull(id);
        Groupa groupa = session.get(Groupa.class, id);
        assertNotNull(groupa);

    }

}
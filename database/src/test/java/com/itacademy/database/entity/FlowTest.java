package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class FlowTest {
    private static SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();
    @Test
    public void  checkSaveEntityFlow(){
        @Cleanup
        Session session = FACTORY.openSession();
        Flow flow = new Flow().builder()
                .name("16/2")
                .build();
        Serializable id = session.save(flow);
        assertNotNull(id);
    }

    @Test
    public void checkGetEntityFlw(){
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Flow().builder().name("18/1").build());
        assertNotNull(id);
        Flow flow = session.get(Flow.class,id);
        assertNotNull(flow);

    }

}
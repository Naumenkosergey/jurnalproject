package com.itacademy.database.entity;

import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class EmployeeTest {
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @Test
    public void checkSaveEntityEmployee() {
        @Cleanup
        Session session = FACTORY.openSession();
        Employee employee = new Employee().builder()
                .name("Коля")
                .surname("козлов")
                .build();
        Serializable id = session.save(employee);
        assertNotNull(id);
    }

    @Test
    public void checGetEntityEmployee() {
        @Cleanup
        Session session = FACTORY.openSession();
        Serializable id = session.save(new Employee().builder()
                .name("Коля")
                .surname("козлов")
                .build());
        assertNotNull(id);
        Employee employee = session.get(Employee.class, id);
        System.out.println(employee);
        assertNotNull(employee);
    }
}
package com.itacademy.database.dao;

import com.itacademy.database.entity.Role;
import com.itacademy.database.util.FillingDB;
import com.itacademy.database.util.HibernateSessionFactoryUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class RoleDaoTest {

    private static final SessionFactory FACTORY = HibernateSessionFactoryUtil.getSessionFactory();
    private final RoleDao roleDao = RoleDao.getInstance();

    @Before
    public void prepare() {
        FillingDB.getInstance().importDdataForTest(FACTORY);
    }

    @AfterClass
    public static void clear() {
        FACTORY.close();
    }

    @Test
    public void testDelete() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Role role = session.get(Role.class, 1L);
        roleDao.delete(role);
        session.flush();
        assertFalse(roleDao.get(role.getId()).isPresent());
        session.getTransaction().commit();
    }
}
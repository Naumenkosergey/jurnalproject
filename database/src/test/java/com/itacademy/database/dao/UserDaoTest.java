package com.itacademy.database.dao;

import com.itacademy.database.entity.User;
import com.itacademy.database.util.FillingDB;
import com.itacademy.database.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserDaoTest {
    private static final SessionFactory FACTORY = HibernateSessionFactoryUtil.getSessionFactory();

    private final UserDao userDao = UserDao.getInstance();

    @Before
    public static void prepare() {
        FillingDB.getInstance().importDdataForTest(FACTORY);
    }

    @AfterClass
    public static void clear() {
        FACTORY.close();
    }

    @Test
    public void checkSaveEntity() {
        Session session = FACTORY.openSession();
        User user = session.get(User.class, 1L);
        userDao.save(user);
        assertTrue(userDao.get(user.getId()).isPresent());
    }

//    @Test
//    public void testFindAll() {
//        @Cleanup
//        Session session = FACTORY.openSession();
//        session.beginTransaction();
//        List<User> results = userDao.findAll();
//        List<String>users=new ArrayList<>();
//        for (User result : results) {
//            String user = result.getLogin();
//            users.add(user);
//        }
//        assertThat(results, hasSize(5));
//        assertThat(users, containsInAnyOrder("Bill Gates", "Steve Jobs", "Sergey Brin", "Tim Cook", "Diane Greene"));
//
//
//    }

}
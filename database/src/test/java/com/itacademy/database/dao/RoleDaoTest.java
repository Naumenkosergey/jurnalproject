package com.itacademy.database.dao;

public class RoleDaoTest {

//    private static final SessionFactory FACTORY = HibernateSessionFactoryUtil.getSessionFactory();
//    private final RoleDao roleDao = RoleDao.getInstance();
//
//    @Before
//    public void prepare() {
//        DataBaseHelper.getInstance().importDdataForTest(FACTORY);
//    }
//
//    @AfterClass
//    public static void clear() {
//        FACTORY.close();
//    }
//
//    @Test
//    public void testDelete() {
//        @Cleanup Session session = FACTORY.openSession();
//        session.beginTransaction();
//        Role role = session.get(Role.class, 1L);
//        roleDao.delete(role);
//        session.flush();
//        assertFalse(roleDao.get(role.getId()).isPresent());
//        session.getTransaction().commit();
//    }
}
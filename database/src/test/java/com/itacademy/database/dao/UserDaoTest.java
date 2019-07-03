package com.itacademy.database.dao;

import com.itacademy.database.config.DataBaseConfig;
import com.itacademy.database.entity.Role;
import com.itacademy.database.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataBaseConfig.class)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void checBeanNotNull(){

        assertNotNull(userDao);
    }

    @Test
    public void checkSave(){

        Role teacher = Role.builder()
                .name("teacher")
                .build();
        User user = User.builder()
                .login("naymchik")
                .password("qwerty")
                .role(teacher)
                .build();
        userDao.save(user);
        assertNotNull(user);
    }
}
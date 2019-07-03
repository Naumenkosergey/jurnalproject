package com.itacademy.service;

import com.itacademy.database.entity.User;
import com.itacademy.service.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void find() {
        Optional<User> user = userService.findById(1L);
        assertFalse(user.isPresent());
    }
    @Test
    public void getByLogin() {
        Optional<User> user = userService.getUserByLogin("Torgan");
        assertFalse(user.isPresent());
    }

//    @Test
//    public void save() {
//        Role teacher = Role.builder()
//                .name("teacher")
//                .build();
//        User user = User.builder()
//                .login("naymchik")
//                .password("qwerty")
//                .role(teacher)
//                .build();
//        userService.save(user);
//        System.out.println(user);
//        assertNotNull(user);
//    }
}
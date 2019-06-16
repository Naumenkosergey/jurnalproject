package com.itacademy.service;

import com.itacademy.database.entity.Role;
import com.itacademy.database.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void find() {
        Optional<User> user = userService.find(1L);
        assertFalse(user.isPresent());
    }

    @Test
    public void save() {
        Role teacher = Role.builder()
                .name("teacher")
                .build();
        User user = User.builder()
                .login("naymchik")
                .password("qwerty")
                .role(teacher)
                .build();
        userService.save(user);
        System.out.println(user);
        assertNotNull(user);
    }
}
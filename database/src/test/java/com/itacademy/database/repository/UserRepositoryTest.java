package com.itacademy.database.repository;

import com.itacademy.database.config.TestConfig;
import com.itacademy.database.entity.Role;
import com.itacademy.database.entity.User;
import com.itacademy.database.util.DataBaseHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
@Commit
public class UserRepositoryTest {

    @Autowired
    private DataBaseHelper dataBaseHelper;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init(){
        dataBaseHelper.cleanDatabase();
        dataBaseHelper.insertData();
    }

    @Test
    public void checkGetById(){
        String login = "Torgan";
        Optional<User> user = userRepository.findByLogin(login);
        Assert.assertNotNull(user);
    }

    @Test
    public void checkSave(){
        Role role = new Role().builder().name("Администратратор").build();
        User user = new User().builder().login("naymchik").password("password").role(role).build();
        userRepository.save(user);
        Assert.assertNotNull(user);
    }







}
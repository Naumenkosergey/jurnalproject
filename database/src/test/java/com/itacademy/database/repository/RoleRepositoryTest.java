package com.itacademy.database.repository;

import com.itacademy.database.config.TestConfig;
import com.itacademy.database.entity.Role;
import com.itacademy.database.util.DataBaseHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DataBaseHelper dataBaseHelper;


    @Before
    public void init(){
        dataBaseHelper.cleanDatabase();
        dataBaseHelper.insertData();
    }

    @Test
    public void checkSave(){
        Role role = new Role().builder().name("Администратратор").build();
        roleRepository.save(role);
        Assert.assertNotNull(role);
    }

}
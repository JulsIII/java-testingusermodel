package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplicationTesting;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplicationTesting.class,
    properties = {
        "command.line.runner.enabled=false"})
public class UserServiceImplNoDBTest
{
    @Autowired
    private UserService userService;
    
    @MockBean
    private UserRepository userrepos;

    @MockBean RoleService roleService;

    @MockBean
    HelperFunctions helperFunctions;

    private List<User> userList;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUserById() {
    }

    @Test
    public void findByNameContaining() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByName() {
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteAll() {
    }
}
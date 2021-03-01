package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplicationTesting;
import com.lambdaschool.usermodel.exceptions.ResourceFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplicationTesting.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplWithDBTest
{
    @Autowired
    private UserService userService;

    @MockBean
    HelperFunctions helperFunctions;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void B_findUserById()
    {
        assertEquals("admin",
                userService.findUserById(4)
                    .getUsername());
    }

    @Test(expected = ResourceFoundException.class)
    public void BA_findUserByIdNotFound()
    {
        assertEquals("admin",
                userService.findUserById(10)
                        .getUsername());
    }

    @Test
    public void C_findAll()
    {
        assertEquals(5,
                userService.findAll()
                    .size());
    }

    @Test
    public void D_delete()
    {
        userService.delete(13);
        assertEquals(4,
                userService.findAll()
                    .size());
    }

    @Test
    public void DA_notFoundDelete()
    {
        userService.delete(100);
        assertEquals(4,
                userService.findAll()
                        .size());
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
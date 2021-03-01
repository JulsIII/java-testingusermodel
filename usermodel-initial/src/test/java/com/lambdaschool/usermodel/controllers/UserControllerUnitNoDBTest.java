package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.UserModelApplicationTesting;
import com.lambdaschool.usermodel.models.Role;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.models.UserRoles;
import com.lambdaschool.usermodel.models.Useremail;
import com.lambdaschool.usermodel.services.UserService;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WithMockUser(username = "admin",
    roles = {"USER", "ADMIN"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = UserModelApplicationTesting.class,
    properties = {
        "command.line.runner.enabled=false"})
@AutoConfigureMockMvc
public class UserControllerUnitNoDBTest
{
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private List<User> userList;

    @Before
    public void setUp() throws Exception
    {
        userList = new ArrayList<>();

        Role r1 = new Role("admin");
        r1.setRoleid(1);
        Role r2 = new Role("user");
        r2.setRoleid(2);
        Role r3 = new Role("data");
        r3.setRoleid(3);

        User u1 = new User("admin",
                "ILuvM4th!",
                "admin@lambdaschool.test");
        u1.getRoles()
                .add(new UserRoles(u1,
                        r1));
        u1.getRoles()
                .add(new UserRoles(u1,
                        r2));
        u1.getRoles()
                .add(new UserRoles(u1,
                        r3));

        u1.getUseremails()
                .add(new Useremail(u1,
                        "admin.email.test"));
        u1.getUseremails()
                .get(0)
                .setUseremailid(10);

        u1.getUseremails()
                .add(new Useremail(u1,
                        "admin.email.test"));
        u1.getUseremails()
                .get(1)
                .setUseremailid(11);

        u1.setUserid(101);
        userList.add(u1);

        ArrayList<UserRoles> datas = new ArrayList<>();
        User u2 = new User("cinnamon",
                "1234567",
                "cinnamon@lambdaschool.test");
        u1.getRoles()
                .add(new UserRoles(u2,
                        r2));
        u1.getRoles()
                .add(new UserRoles(u2,
                        r3));

        u2.getUseremails()
                .add(new Useremail(u2,
                        "cinnamon@mymail.test"));
        u2.getUseremails()
                .get(0)
                .setUseremailid(20);

        u2.getUseremails()
                .add(new Useremail(u2,
                        "hops@mymail.test"));
        u2.getUseremails()
                .get(1)
                .setUseremailid(21);

        u2.getUseremails()
                .add(new Useremail(u2,
                        "bunny@email.test"));
        u2.getUseremails()
                .get(2)
                .setUseremailid(22);

        u2.setUserid(102);
        userList.add(u2);

        //user
        User u3 = new User("testingbarn",
                "IluvM4th!",
                "testingbarn@school.lambda");
        u3.getRoles()
                .add(new UserRoles(u3,
                        r1));

        u3.getUseremails()
                .add(new Useremail(u3,
                        "barnbarn@email.test"));
        u3.getUseremails()
                .get(0)
                .setUseremailid(30);

        u3.setUserid(103);
        userList.add(u3);

        User u4 = new User("testingcat",
                "password",
                "testingcat@school.lambda");
        u4.getRoles()
                .add(new UserRoles(u4,
                        r2));

        u4.setUserid(104);
        userList.add(u4);

        User u5 = new User("testingdog",
                "password",
                "testingdog@school.lambda");
        u4.getRoles()
                .add(new UserRoles(u5,
                        r2));

        u5.setUserid(105);
        userList.add(u5);

        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllUsers() {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void getUserByName() {
    }

    @Test
    public void getUserLikeName() {
    }

    @Test
    public void addNewUser() {
    }

    @Test
    public void updateFullUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void getCurrentUserInfo() {
    }
}
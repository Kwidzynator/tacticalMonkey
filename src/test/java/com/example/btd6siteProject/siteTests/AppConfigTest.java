package com.example.btd6siteProject.siteTests;

import com.example.btd6siteProject.controller.LoginSiteController;
import com.example.btd6siteProject.service.MonkeyService;
import com.example.btd6siteProject.service.MonkeyTypeService;
import com.example.btd6siteProject.service.PostService;
import com.example.btd6siteProject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AppConfigTest {

    @Autowired
    private LoginSiteController loginSiteController;
    @Autowired
    private PostService postService;
    @Autowired
    private MonkeyService monkeyService;
    @Autowired
    private MonkeyTypeService monkeyTypeService;
    @Autowired
    private UserService userService;

    @Test
    void testLoginSiteControllerBean(){
        assertThat(loginSiteController).isNotNull();
    }

    @Test
    void testPostServiceBean(){
        assertThat(postService).isNotNull();
    }

    @Test
    void testUserServiceBean(){
        assertThat(userService).isNotNull();
    }

    @Test
    void testMonkeyTypeServiceBean(){
        assertThat(monkeyTypeService).isNotNull();
    }

    @Test
    void testMonkeyBean(){
        assertThat(monkeyService).isNotNull();
    }

}

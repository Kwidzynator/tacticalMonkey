package com.example.btd6siteProject.db;

import com.example.btd6siteProject.model.entity.AppUser;
import com.example.btd6siteProject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@SpringBootTest
public class UserTests {
    @Autowired
    private UserService userService;

    public UserTests(UserService userService){
        this.userService = userService;
    }

    @Test
    public void authorizationTest(){
        AppUser appUser = new AppUser();
        appUser.setUsername("a");
        appUser.setPassword("b");

        assertThat(userService.authorization(appUser.getUsername(), appUser.getPassword())).isNotPresent();

        appUser.setPassword("a");
        assertThat(userService.authorization(appUser.getUsername(), appUser.getPassword())).isPresent();

    }
}

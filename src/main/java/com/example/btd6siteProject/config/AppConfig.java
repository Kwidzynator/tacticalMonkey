package com.example.btd6siteProject.config;

import com.example.btd6siteProject.controller.LoginSiteController;
import com.example.btd6siteProject.repository.MonkeyRepository;
import com.example.btd6siteProject.repository.MonkeyTypeRepository;
import com.example.btd6siteProject.repository.PostRepository;
import com.example.btd6siteProject.repository.UserRepository;
import com.example.btd6siteProject.service.MonkeyService;
import com.example.btd6siteProject.service.MonkeyTypeService;
import com.example.btd6siteProject.service.PostService;
import com.example.btd6siteProject.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MonkeyService monkeyService(MonkeyRepository monkeyRepository){
        return new MonkeyService(monkeyRepository);
    }

    @Bean
    public PostService postService(PostRepository postRepository){
        return new PostService(postRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }

    @Bean
    public MonkeyTypeService monkeyTypeService(MonkeyTypeRepository monkeyTypeRepository)
    {
        return new MonkeyTypeService(monkeyTypeRepository);
    }

    @Bean
    public LoginSiteController loginSiteController(UserService userService){
        return new LoginSiteController(userService);
    }

}

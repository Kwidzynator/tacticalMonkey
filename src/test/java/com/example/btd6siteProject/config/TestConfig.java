package com.example.btd6siteProject.config;

import com.example.btd6siteProject.db.MonkeyTests;
import com.example.btd6siteProject.db.UserTests;
import com.example.btd6siteProject.repository.MonkeyRepository;
import com.example.btd6siteProject.repository.MonkeyTypeRepository;
import com.example.btd6siteProject.repository.UserRepository;
import com.example.btd6siteProject.service.MonkeyService;
import com.example.btd6siteProject.service.UserService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@TestConfiguration
public class TestConfig {
    @Bean
    public MonkeyTests monkeyTests(MonkeyService monkeyService, MonkeyRepository monkeyRepository, MonkeyTypeRepository monkeyTypeRepository){
        return new MonkeyTests(monkeyService, monkeyRepository, monkeyTypeRepository);
    }
    @Bean
    public UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        return new UserService(userRepository, passwordEncoder);
    }
    @Bean
    public UserTests userTests(UserService userService){
        return new UserTests(userService);
    }
}

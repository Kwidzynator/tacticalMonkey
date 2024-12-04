package com.example.btd6siteProject.config;

import com.example.btd6siteProject.db.MonkeyTests;
import com.example.btd6siteProject.repository.MonkeyRepository;
import com.example.btd6siteProject.repository.MonkeyTypeRepository;
import com.example.btd6siteProject.service.MonkeyService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public MonkeyTests monkeyTests(MonkeyService monkeyService, MonkeyRepository monkeyRepository, MonkeyTypeRepository monkeyTypeRepository){
        return new MonkeyTests(monkeyService, monkeyRepository, monkeyTypeRepository);
    }
}

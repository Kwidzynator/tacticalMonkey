package com.example.btd6siteProject.service;

import com.example.btd6siteProject.repository.MonkeyTypeRepository;
import com.example.btd6siteProject.repository.UserRepository;
import org.springframework.stereotype.Service;


public class MonkeyTypeService {
    private MonkeyTypeRepository monkeyTypeRepository;

    public MonkeyTypeService(MonkeyTypeRepository monkeyTypeRepository){
        this.monkeyTypeRepository = monkeyTypeRepository;
    }

}

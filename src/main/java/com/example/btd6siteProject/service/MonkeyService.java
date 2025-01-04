package com.example.btd6siteProject.service;

import com.example.btd6siteProject.model.entity.Monkey;
import com.example.btd6siteProject.model.entity.MonkeyType;
import com.example.btd6siteProject.repository.MonkeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MonkeyService {
    private final MonkeyRepository monkeyRepository;
    public MonkeyService(MonkeyRepository monkeyRepository) {
        this.monkeyRepository = monkeyRepository;
    }

    public Monkey findById(int id) { return monkeyRepository.findById(id); }
    public List<Monkey> getMonkeysByType(MonkeyType type) {
        return monkeyRepository.findByMonkeyType(type);
    }

    public List<Monkey> getMonkeysByName(String name) {
        return monkeyRepository.findByName(name);
    }
    public Optional<Monkey> findMonkeyByRows(Integer row1, Integer row2, Integer row3) {
        return monkeyRepository.findMonkeyByRows(row1, row2, row3);
    }


    public Boolean checkIfMonkeyRowsAreOK(Integer row1, Integer row2, Integer row3){
        if(row1 > 0 && row2 > 0 && row3 > 0){
            return false;
        }

        if(checkGreatnessCondition(row1, row2, row3)){
            return true;
        }

        if(checkGreatnessCondition(row2, row1, row3)){
            return true;
        }

        if(checkGreatnessCondition(row3, row2, row3)){
            return true;
        }

        return true;
    }

    private Boolean checkGreatnessCondition(int row1, int row2, int row3){
        return row1 >= 3 && ((row2 <= 2 && row3 == 0) || (row2 == 0 && row3 <= 0));
    }
}

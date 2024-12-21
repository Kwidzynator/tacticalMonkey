package com.example.btd6siteProject.service;


import com.example.btd6siteProject.model.entity.GameMap;
import com.example.btd6siteProject.repository.GameMapRepository;

import java.util.List;
import java.util.Optional;

public class GameMapService {
    private final GameMapRepository gameMapRepository;

    public GameMapService(GameMapRepository gameMapRepository){
        this.gameMapRepository = gameMapRepository;
    }

    public Optional<GameMap> findGameMapsByMapName(String name){
        return gameMapRepository.findGameMapsByMapName(name);
    }

    public Optional<GameMap> findGameMapsByMapDifficulty(String difficulty){
        return gameMapRepository.findGameMapsByMapDifficulty(difficulty);
    }

    public List<GameMap> findAll(){
        return gameMapRepository.findAll();
    }
}

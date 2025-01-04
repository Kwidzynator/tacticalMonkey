package com.example.btd6siteProject.repository;

import com.example.btd6siteProject.model.entity.GameMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GameMapRepository extends JpaRepository<GameMap, Long> {
    GameMap findGameMapsById(int id);
    Optional<GameMap> findGameMapsByMapName(String name);
    Optional<GameMap> findGameMapsByMapDifficulty(String difficulty);


}

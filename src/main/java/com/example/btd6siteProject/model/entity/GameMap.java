package com.example.btd6siteProject.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "maps")
public class GameMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "map_name", nullable = false)
    private String mapName;

    @Column(name = "map_difficulty")
    private String mapDifficulty;
    public String getMapName() {
        return mapName;
    }

    public Integer getId() {
        return id;
    }
}

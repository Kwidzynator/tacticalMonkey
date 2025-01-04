package com.example.btd6siteProject.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    @Column(name = "map_img", columnDefinition = "BYTEA")
    private byte[] mapImg;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private GameMap map;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMapImg(byte[] mapImg) {
        this.mapImg = mapImg;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
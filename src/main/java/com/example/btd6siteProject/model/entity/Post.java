package com.example.btd6siteProject.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private User user;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;



}
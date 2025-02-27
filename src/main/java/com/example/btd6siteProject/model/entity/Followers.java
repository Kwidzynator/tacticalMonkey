package com.example.btd6siteProject.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "follows")
public class Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "following_user_id", nullable = false)
    private AppUser followingAppUser;

    @ManyToOne
    @JoinColumn(name = "followed_user_id", nullable = false)
    private AppUser followedAppUser;

    @Column(name = "followed_at", nullable = false)
    private LocalDateTime createdAt;
}

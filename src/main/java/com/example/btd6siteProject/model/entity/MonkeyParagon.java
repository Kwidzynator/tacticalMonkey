package com.example.btd6siteProject.model.entity;

import jakarta.persistence.*;

public class MonkeyParagon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private MonkeyType type;

    private String name;

}

package com.example.btd6siteProject.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "monkeys_types")
public class MonkeyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_name", nullable = false)
    private String typeName;

    @OneToMany(mappedBy = "type")
    private List<Monkey> monkeys;

    // Getters and Setters

    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) { this.typeName = typeName; }

}
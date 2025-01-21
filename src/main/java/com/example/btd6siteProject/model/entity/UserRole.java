package com.example.btd6siteProject.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "role")
    @Column(name="user_id")
    private List<AppUser> users;

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }

    public String getName(){
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }
}
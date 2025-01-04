package com.example.btd6siteProject.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="points")
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private Post post;

    private float x;
    private float y;

    @ManyToOne
    @JoinColumn(name="monkey_id", nullable = false)
    private Monkey monkey;

    public void setPost(Post post) {
        this.post = post;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }
}

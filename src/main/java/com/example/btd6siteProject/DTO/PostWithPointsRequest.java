package com.example.btd6siteProject.DTO;

import com.example.btd6siteProject.model.entity.Points;
import com.example.btd6siteProject.model.entity.Post;

import java.util.List;

public class PostAndPointsDto {

    private Post post;
    private List<Points> points;

    public PostAndPointsDto(Post post, List<Points> points) {
        this.post = post;
        this.points = points;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Points> getPoints() {
        return points;
    }

    public void setPoints(List<Points> points) {
        this.points = points;
    }
}

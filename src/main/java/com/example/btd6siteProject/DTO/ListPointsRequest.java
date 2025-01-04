package com.example.btd6siteProject.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ListPointsRequest {
    @NotNull
    private int postId;

    @Valid
    @NotNull
    private List<PointsRequest> points;

    public int getPostId() {
        return postId;
    }

    public List<PointsRequest> getPoints() {
        return points;
    }
}

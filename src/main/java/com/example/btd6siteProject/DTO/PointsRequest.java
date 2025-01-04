package com.example.btd6siteProject.DTO;

import jakarta.validation.constraints.NotNull;

public class PointsRequest {
    @NotNull
    private int postId;

    @NotNull
    private float x;

    @NotNull
    private float y;

    @NotNull
    private int monkeyId;

    public int getPostId() {
        return postId;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getMonkeyId() {
        return monkeyId;
    }
}

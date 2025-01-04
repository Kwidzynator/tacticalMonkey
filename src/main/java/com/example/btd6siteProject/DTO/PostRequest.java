package com.example.btd6siteProject.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostRequest {
    @NotBlank(message = "title cannot be empty")
    private String title;

    private String description;

    @NotNull
    private String mapImg;
    @NotNull
    private int mapId;

    @NotNull
    private int userId;
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMapImg() {
        return mapImg;
    }

    public int getMapId() {
        return mapId;
    }

    public int getUserId(){
        return userId;
    }
}

package com.example.btd6siteProject.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostRequest {
    @NotBlank(message = "title cannot be empty")
    private String title;

    private String description;

    @NotNull
    private byte[] mapImg;

    private int mapId;
}

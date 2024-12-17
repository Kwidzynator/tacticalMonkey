package com.example.btd6siteProject.DTO;

import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

public class LoginRequest {
    @NotBlank(message = "username cannot be null/blank")
    private String username;
    @NotBlank(message = "password cannot be null/blank")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.btd6siteProject.DTO;

import com.example.btd6siteProject.validators.annotations.UniqueEmail;
import com.example.btd6siteProject.validators.annotations.UniqueUsername;
import com.example.btd6siteProject.validators.annotations.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
    @NotBlank(message = "username cannot be null/blank")
    @UniqueUsername(message = "username taken :c")
    @Size(max=32, message = "username cannot be longer than 32 digits")
    private String username;
    @Email(message = "invalid email type")
    @NotBlank(message = "email cannot be null/blank")
    @UniqueEmail(message = "email already used :c")
    @Size(max = 255)
    private String email;
    @NotBlank(message = "password cannot be null/blank")
    @ValidPassword(message = "invalid password, your password has to have, one special character, one uppercase")
    @Size(min = 7, max = 255, message = "password cannot be shorter than 7 digits")
    private String password;
    private String role = "USER";
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

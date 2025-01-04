package com.example.btd6siteProject.service;

import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptionService {
    private PasswordEncoder passwordEncoder;

    public EncryptionService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean passwordMatches(String rawPassword, String storedHash){
        return passwordEncoder.matches(rawPassword, storedHash);
    }
}

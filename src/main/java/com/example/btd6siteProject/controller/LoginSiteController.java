package com.example.btd6siteProject.controller;

import com.example.btd6siteProject.DTO.LoginRequest;
import com.example.btd6siteProject.model.entity.AppUser;
import com.example.btd6siteProject.service.EncryptionService;
import com.example.btd6siteProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginSiteController {

    private final AuthenticationManager authenticationManager;
    private final MessageSource messageSource;

    public LoginSiteController(MessageSource messageSource, AuthenticationManager authenticationManager) {
        this.messageSource = messageSource;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/language")
    public ResponseEntity<Map<String, String>> setLanguage(@RequestHeader(value = "used-language", defaultValue = "en") String language) {
        Locale locale = Locale.forLanguageTag(language);

        String usernameLabel = messageSource.getMessage("login.username", null, locale);
        String passwordLabel = messageSource.getMessage("login.password", null, locale);
        String submitButton = messageSource.getMessage("login.sbmit", null, locale);
        String registerButton = messageSource.getMessage("login.register", null, locale);

        Map<String, String> response = new HashMap<>();
        response.put("username", usernameLabel);
        response.put("password", passwordLabel);
        response.put("sbmit", submitButton);
        response.put("register", registerButton);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/loginInto")
    public ResponseEntity<String> loginButtonPressed(@RequestBody @Valid LoginRequest loginRequest) {
        try {

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), loginRequest.getPassword());




            authenticationManager.authenticate(authToken);
            System.out.println("Authorization successful"); // If successful

            return ResponseEntity.ok("Login succeed");
        } catch (AuthenticationException e) {

            System.out.println("Authentication failed with exception: " + e.getMessage());


            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}

package com.example.btd6siteProject.controller;

import com.example.btd6siteProject.DTO.RegisterRequest;
import com.example.btd6siteProject.service.EncryptionService;
import com.example.btd6siteProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/register")
public class RegisterSiteController {
    private final UserService userService;
    private final MessageSource messageSource;

    private final EncryptionService encryptionService;

    public RegisterSiteController(UserService userService, MessageSource messageSource, EncryptionService encryptionService) {
        this.userService = userService;
        this.messageSource = messageSource;
        this.encryptionService = encryptionService;
    }

    @GetMapping("/language")
    public ResponseEntity<Map<String, String>> setLanguage(@RequestHeader(value = "used-language", defaultValue = "en") String language){
        Locale locale = Locale.forLanguageTag(language);

        String usernameLabel = messageSource.getMessage("login.username", null, locale);
        String passwordLabel = messageSource.getMessage("login.password", null, locale);
        String emailLabel = messageSource.getMessage("register.email", null, locale);
        String submitButton = messageSource.getMessage("register.sbmit", null, locale);
        String loginButton = messageSource.getMessage("register.login", null, locale);

        Map<String, String> response = new HashMap<>();
        response.put("username", usernameLabel);
        response.put("password", passwordLabel);
        response.put("email", emailLabel);
        response.put("sbmit", submitButton);
        response.put("login", loginButton);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/createAcc")
    public ResponseEntity<String> createAccount(@RequestBody @Valid RegisterRequest registerRequest){
        String username = registerRequest.getUsername();
        String email = registerRequest.getEmail();
        String password = registerRequest.getPassword();
        String role = registerRequest.getRole();


        System.out.println();
        System.out.println(password);
        System.out.println();

        userService.createUser(username, email, password);

        return ResponseEntity.ok("account successfully created");

    }

}

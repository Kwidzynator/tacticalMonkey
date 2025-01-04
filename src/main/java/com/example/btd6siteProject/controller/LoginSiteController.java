package com.example.btd6siteProject.controller;

import com.example.btd6siteProject.DTO.LoginRequest;
import com.example.btd6siteProject.model.entity.AppUser;
import com.example.btd6siteProject.service.EncryptionService;
import com.example.btd6siteProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginSiteController {


    private final UserService userService;
    private final MessageSource messageSource;
    private final EncryptionService encryptionService;
    public LoginSiteController(UserService userService, MessageSource messageSource, EncryptionService encryptionService){
        this.userService = userService;
        this.messageSource = messageSource;
        this.encryptionService = encryptionService;
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
    public ResponseEntity<String> loginButtonPressed(@RequestBody @Valid LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Optional<AppUser> userOptional = userService.findByUsername(username);

        if(userOptional.isPresent()){
            AppUser user = userOptional.get();
            if(encryptionService.passwordMatches(password, user.getPassword()))
            System.out.println("authorized");
            return ResponseEntity.ok("Login succeed");
        }
        else{
            System.out.println("user does not exist");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

}

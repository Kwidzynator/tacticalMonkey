package com.example.btd6siteProject.controller;

import com.example.btd6siteProject.DTO.RegisterRequest;
import com.example.btd6siteProject.model.entity.User;
import com.example.btd6siteProject.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/register")
public class RegisterSiteController {
    private UserService userService;
    private MessageSource messageSource;

    public RegisterSiteController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
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
    public ResponseEntity<String> createAccount(@RequestBody RegisterRequest registerRequest){
        String username = registerRequest.getUsername();
        String email = registerRequest.getEmail();
        String password = registerRequest.getPassword();
        String role = registerRequest.getRole();

        ResponseEntity response = checkConditions(username, password, email);
        if(response.getStatusCode().is4xxClientError()){
            return response;
        }


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole("USER");
        userService.save(user);
        return ResponseEntity.ok("account successfully created");

    }

    private ResponseEntity<String> checkConditions(String username, String password, String email){
        if(Stream.of(username, email, password).anyMatch(this::checkIfEmpty)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("some field is empty");
        }

        if(!checkPasswordConditions(password)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("password doesnt require conditions: longer than 7," +
                    " has special character, has at least one uppercase");
        }
        Optional<User> userOptional = userService.findByEmail(email);
        if(userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already used");
        }
        userOptional = userService.findByUsername(username);
        if(userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username is taken");
        }
        return ResponseEntity.ok("everything is fine");
    }
    private boolean checkIfEmpty(String content){
        return content.isEmpty();
    }

    private boolean checkPasswordConditions(String password){
        if(password.length() < 7){
            return false;
        }

        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasSpecialCharacter = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));

        return hasUpperCase && hasSpecialCharacter;
    }

}

package com.example.btd6siteProject.controller;

import com.example.btd6siteProject.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loginSite")
public class LoginSiteController {


    private final UserService userService;

    public LoginSiteController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/loginSite")
    public ResponseEntity<String> loginSite(){
        return ResponseEntity.ok("welcome to uganda");
    }
}

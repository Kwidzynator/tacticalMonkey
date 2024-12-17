package com.example.btd6siteProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectingSitesController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "loginSite";
    }

    @GetMapping("/register")
    public String showRegisterPage(){
        return "registerSite";
    }

    @GetMapping("")
    public String showMainSitePage(){
        return "mainSite";
    }

    @GetMapping("/createPost")
    public String showMakingPostSite(){
        return "makingPostSite";
    }
}

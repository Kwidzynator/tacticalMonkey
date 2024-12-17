package com.example.btd6siteProject.controller;

import com.example.btd6siteProject.DTO.PostRequest;
import com.example.btd6siteProject.service.PostService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/makingPost")
public class MakingPostSiteController {
    private final MessageSource messageSource;
    private final PostService postService;
    public MakingPostSiteController(MessageSource messageSource, PostService postService){
        this.messageSource = messageSource;
        this.postService = postService;
    }
    @GetMapping("/language")
    public ResponseEntity<Map<String, String>> setLanguage(@RequestHeader(value= "used-language", defaultValue = "en") String language){
        Locale locale = Locale.forLanguageTag(language);

        String titleLabel = messageSource.getMessage("post.title", null, locale);
        String descriptionLabel = messageSource.getMessage("post.description", null, locale);
        String mapNameLabel = messageSource.getMessage("post.mapName", null, locale);
        String mapImgLabel = messageSource.getMessage("post.map", null, locale);

        Map<String, String> response = new HashMap<>();

        response.put("title", titleLabel);
        response.put("description", descriptionLabel);
        response.put("mapName", mapNameLabel);
        response.put("map", mapImgLabel);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/post")
    public ResponseEntity<String> makePost(@RequestBody @Valid PostRequest postRequest){



        return ResponseEntity.ok("");
    }

}

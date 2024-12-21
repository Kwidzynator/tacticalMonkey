package com.example.btd6siteProject.controller;

import com.example.btd6siteProject.DTO.PostRequest;
import com.example.btd6siteProject.model.entity.GameMap;
import com.example.btd6siteProject.service.GameMapService;
import com.example.btd6siteProject.service.PostService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/makingPost")
public class MakingPostSiteController {
    private final MessageSource messageSource;
    private final PostService postService;

    private final GameMapService gameMapService;
    public MakingPostSiteController(MessageSource messageSource, PostService postService, GameMapService gameMapService){
        this.messageSource = messageSource;
        this.postService = postService;
        this.gameMapService = gameMapService;
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

    @GetMapping("/maps")
    public ResponseEntity<Map<Integer, String>> giveMapNames() {
        List<GameMap> maps = gameMapService.findAll();

        Map<Integer, String> mapNames = maps.stream().collect(Collectors.toMap(
                GameMap::getId,
                GameMap::getMapName
        ));


        return ResponseEntity.ok(mapNames);
    }

    @PostMapping("/post")
    public ResponseEntity<String> makePost(@RequestBody @Valid PostRequest postRequest){



        return ResponseEntity.ok("");
    }

}

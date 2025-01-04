package com.example.btd6siteProject.controller;

import com.example.btd6siteProject.DTO.ListPointsRequest;
import com.example.btd6siteProject.DTO.PointsRequest;
import com.example.btd6siteProject.DTO.PostRequest;
import com.example.btd6siteProject.model.entity.GameMap;
import com.example.btd6siteProject.model.entity.Points;
import com.example.btd6siteProject.model.entity.Post;
import com.example.btd6siteProject.service.GameMapService;
import com.example.btd6siteProject.service.MonkeyService;
import com.example.btd6siteProject.service.PointsService;
import com.example.btd6siteProject.service.PostService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/makingPost")
public class MakingPostSiteController {
    private final MessageSource messageSource;
    private final PostService postService;
    private final GameMapService gameMapService;
    private final MonkeyService monkeyService;

    private final PointsService pointsService;
    public MakingPostSiteController(MessageSource messageSource, PostService postService, GameMapService gameMapService,
                                    MonkeyService monkeyService, PointsService pointsService){
        this.messageSource = messageSource;
        this.postService = postService;
        this.gameMapService = gameMapService;
        this.monkeyService = monkeyService;
        this.pointsService = pointsService;
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
    public ResponseEntity<String> makePost(@RequestBody @Valid PostRequest postRequest) throws IOException {
        String title = postRequest.getTitle();
        String description = postRequest.getDescription();
        byte[] mapImg = Base64.getDecoder().decode(postRequest.getMapImg());
        GameMap map = gameMapService.findGameMapsById(postRequest.getMapId());
        //int userId = getCurrentUserId();

        postService.createPost(title, description, mapImg, map);

        return ResponseEntity.ok("post created successfully");
    }
    /*private int getCurrentUserId() {
        // Przyklad pobierania userId z tokena lub kontekstu bezpieczeństwa
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getId();
    }*/

    @PostMapping("/points")
    public ResponseEntity<String> addPoints(@RequestBody @Valid ListPointsRequest listPointsRequest){
        int postId = listPointsRequest.getPostId();
        for(PointsRequest p : listPointsRequest.getPoints()){
            Points point = new Points();
            point.setPost(postService.findById(postId));
            point.setX(p.getX());
            point.setY(p.getY());
            point.setMonkey(monkeyService.findById(p.getMonkeyId()));

            pointsService.savePoint(point);
        }


        return ResponseEntity.ok("point added successfully");
    }

}

package com.example.btd6siteProject.service;

import com.example.btd6siteProject.model.entity.Post;
import com.example.btd6siteProject.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findByTitle(String postTitle){
        return postRepository.findByTitle(postTitle);
    }

    public List<Post> findByMapName(String mapName){
        return postRepository.findByMap_MapName(mapName);
    }

    public List<Post> findNewestPosts(){
        return postRepository.findNewestPosts();
    }
}

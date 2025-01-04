package com.example.btd6siteProject.service;

import com.example.btd6siteProject.model.entity.GameMap;
import com.example.btd6siteProject.model.entity.Post;
import com.example.btd6siteProject.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.zip.GZIPOutputStream;


public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(int id){ return postRepository.findById(id); }
    public Optional<Post> findByTitle(String postTitle){
        return postRepository.findByTitle(postTitle);
    }

    public List<Post> findByMapName(String mapName){
        return postRepository.findByMap_MapName(mapName);
    }

    public List<Post> findNewestPosts(){
        return postRepository.findNewestPosts();
    }

    public void savePost(Post post){
        postRepository.save(post);
    }

    public void createPost(String title, String description, byte[] mapImg, GameMap gameMap) throws IOException{
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);

        post.setMap(gameMap);

        LocalDateTime now = LocalDateTime.now();
        post.setCreatedAt(now);

        System.out.println();
        System.out.println(title);
        System.out.println(description);

        System.out.println();
        System.out.println("mapImg type: " + mapImg.getClass().getName());
        System.out.println();
        byte[] compressedMapImg = compress(mapImg);
        post.setMapImg(compressedMapImg);

        postRepository.save(post);
    }

    private byte[] compress(byte[] data) throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try(GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)){
            gzipOutputStream.write(data);
        }
        return byteArrayOutputStream.toByteArray();
    }
}

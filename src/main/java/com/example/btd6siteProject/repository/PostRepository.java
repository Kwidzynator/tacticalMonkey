package com.example.btd6siteProject.repository;

import com.example.btd6siteProject.model.entity.GameMap;
import com.example.btd6siteProject.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Optional<Post> findByTitle(@Param("postTitle") String postTitle);
    List<Post> findByMap_MapName(@Param("map_name") String mapName);
    @Query("SELECT p FROM Post p ORDER BY p.createdAt DESC")
    List<Post> findNewestPosts();

}

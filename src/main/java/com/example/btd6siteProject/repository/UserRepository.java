package com.example.btd6siteProject.repository;

import com.example.btd6siteProject.model.entity.AppUser;
import com.example.btd6siteProject.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
    @Query("SELECT f.followingAppUser FROM Followers f WHERE f.followedAppUser.id = :userId")
    List<AppUser> findFollowersByUserId(@Param("userId") Integer userId);

    @Query("SELECT f.followedAppUser FROM Followers f WHERE f.followingAppUser.id = :userId")
    List<AppUser> findFollowingByUserId(@Param("userId") Integer userId);

    @Query("SELECT p FROM Post p WHERE p.appUser.id = :userId")
    List<Post> findPostsByUserId(@Param("userId") Integer userId);

}

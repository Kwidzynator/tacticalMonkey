package com.example.btd6siteProject.repository;

import com.example.btd6siteProject.model.entity.Followers;
import com.example.btd6siteProject.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.btd6siteProject.model.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> createUser(String username, String email, String password);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    @Query("SELECT f.followingUser FROM Followers f WHERE f.followedUser.id = :userId")
    List<User> findFollowersByUserId(@Param("userId") Integer userId);

    @Query("SELECT f.followedUser FROM Followers f WHERE f.followingUser.id = :userId")
    List<User> findFollowingByUserId(@Param("userId") Integer userId);

    @Query("SELECT p FROM Post p WHERE p.user.id = :userId")
    List<Post> findPostsByUserId(@Param("userId") Integer userId);

    @Query("SELECT u from User u WHERE u.username = :username AND u.password = :password")
    Optional<User> authorization(String username, String password);
}

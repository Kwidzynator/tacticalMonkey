package com.example.btd6siteProject.service;

import com.example.btd6siteProject.model.entity.Post;
import com.example.btd6siteProject.model.entity.User;
import com.example.btd6siteProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class UserService{
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public List<User> findFollowersByUserId(Integer userId){
        return userRepository.findFollowersByUserId(userId);
    }
    public List<User> findFollowingByUserId(@Param("userId") Integer userId){
        return userRepository.findFollowingByUserId(userId);
    }

    public List<Post> findPostsByUserId(@Param("userId") Integer userId){
        return userRepository.findPostsByUserId(userId);
    }

    public Optional<User> authorization(String username, String password){
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return userRepository.authorization(username, password);
    }
}

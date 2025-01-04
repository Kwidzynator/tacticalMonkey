package com.example.btd6siteProject.service;

import com.example.btd6siteProject.model.entity.AppUser;
import com.example.btd6siteProject.model.entity.Post;
import com.example.btd6siteProject.repository.UserRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;


public class UserService{
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<AppUser> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Optional<AppUser> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public List<AppUser> findFollowersByUserId(Integer userId){
        return userRepository.findFollowersByUserId(userId);
    }
    public List<AppUser> findFollowingByUserId(@Param("userId") Integer userId){
        return userRepository.findFollowingByUserId(userId);
    }

    public List<Post> findPostsByUserId(@Param("userId") Integer userId){
        return userRepository.findPostsByUserId(userId);
    }

    public void createUser(String username, String email, String password){
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(password);
        appUser.setEmail(email);
        appUser.setRole("ROLE_USER");

        userRepository.save(appUser);

    }
}

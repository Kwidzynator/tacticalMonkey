package com.example.btd6siteProject.service;

import com.example.btd6siteProject.model.entity.AppUser;
import com.example.btd6siteProject.model.entity.Post;
import com.example.btd6siteProject.repository.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;
import java.util.Optional;


public class UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        String encodedPassowrd = passwordEncoder.encode(password);
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(password);
        appUser.setEmail(email);
        appUser.setRole("USER");

        userRepository.save(appUser);

    }
}

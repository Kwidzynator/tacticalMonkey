package com.example.btd6siteProject.validators.classes;

import com.example.btd6siteProject.model.entity.User;
import com.example.btd6siteProject.service.UserService;
import com.example.btd6siteProject.validators.annotations.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.util.Optional;

public class UsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    private UserService userService;
    public UsernameValidator(UserService userService) {
        this.userService = userService;
    }
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {

            Optional<User> userOptional = userService.findByUsername(username);
            System.out.println(userOptional.isPresent());
            return userOptional.isEmpty();
        }
}


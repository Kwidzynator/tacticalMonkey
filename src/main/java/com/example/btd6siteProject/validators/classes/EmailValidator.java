package com.example.btd6siteProject.validators.classes;

import com.example.btd6siteProject.model.entity.AppUser;
import com.example.btd6siteProject.service.UserService;
import com.example.btd6siteProject.validators.annotations.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


import java.util.Optional;

public class EmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private UserService userService;

    public EmailValidator(UserService userService){
        this.userService = userService;
    }
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        Optional<AppUser> userOptional = userService.findByEmail(email);
        return userOptional.isEmpty();
    }
}

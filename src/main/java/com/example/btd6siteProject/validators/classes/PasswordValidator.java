package com.example.btd6siteProject.validators.classes;

import com.example.btd6siteProject.validators.annotations.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

            boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
            boolean hasSpecialCharacter = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));

            return hasUpperCase && hasSpecialCharacter;
        }
        private boolean checkIfEmpty(String content){
            return content.isEmpty();
        }


}

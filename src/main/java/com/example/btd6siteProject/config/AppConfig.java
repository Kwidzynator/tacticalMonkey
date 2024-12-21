package com.example.btd6siteProject.config;

import com.example.btd6siteProject.controller.LoginSiteController;
import com.example.btd6siteProject.controller.MakingPostSiteController;
import com.example.btd6siteProject.controller.RegisterSiteController;
import com.example.btd6siteProject.repository.*;
import com.example.btd6siteProject.service.*;
import com.example.btd6siteProject.validators.classes.EmailValidator;
import com.example.btd6siteProject.validators.classes.PasswordValidator;
import com.example.btd6siteProject.validators.classes.UsernameValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public MonkeyService monkeyService(MonkeyRepository monkeyRepository){
        return new MonkeyService(monkeyRepository);
    }

    @Bean
    public PostService postService(PostRepository postRepository){
        return new PostService(postRepository);
    }

    @Bean
    public UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }

    @Bean
    public GameMapService gameMapService(GameMapRepository gameMapRepository) { return new GameMapService(gameMapRepository);}

    @Bean
    public EncryptionService encryptionService(PasswordEncoder passwordEncoder){
        return new EncryptionService(passwordEncoder);
    }

    @Bean
    public MonkeyTypeService monkeyTypeService(MonkeyTypeRepository monkeyTypeRepository)
    {
        return new MonkeyTypeService(monkeyTypeRepository);
    }

    @Bean
    public LoginSiteController loginSiteController(UserService userService, MessageSource messageSource, EncryptionService encryptionService){
        return new LoginSiteController(userService, messageSource, encryptionService);
    }

    @Bean
    public RegisterSiteController registerSiteController(UserService userService, MessageSource messageSource, EncryptionService encryptionService){
        return new RegisterSiteController(userService, messageSource, encryptionService);
    }

    @Bean
    public MakingPostSiteController makingPostSiteController(MessageSource messageSource, PostService postService, GameMapService gameMapService){
        return new MakingPostSiteController(messageSource, postService, gameMapService);
    }

    @Bean
    public EmailValidator emailValidator(UserService userService){
        return new EmailValidator(userService);
    }
    @Bean
    public UsernameValidator usernameValidator(UserService userService) {
        return new UsernameValidator(userService);
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("html/");
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }

    //TODO move it to SecurityConfig.java while setting it up
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

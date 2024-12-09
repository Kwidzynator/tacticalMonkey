package com.example.btd6siteProject.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private static final List<Locale> SUPPORTED_LOCALES = List.of(
            Locale.UK,            // angielski
            new Locale("pl"),     // polski
            Locale.GERMANY        // niemiecki
    );
    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.UK);
        slr.setDefaultTimeZone(TimeZone.getTimeZone("Europe/London"));
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocaleResolver supportedLocaleResolver() {
        return new SessionLocaleResolver() {
            @Override
            public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
                if (SUPPORTED_LOCALES.contains(locale)) {
                    super.setLocale(request, response, locale);
                } else {
                    super.setLocale(request, response, Locale.UK);
                }
            }
        };
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/html/**")
                .addResourceLocations("classpath:/static/html/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/error").setViewName("index");
    }
}

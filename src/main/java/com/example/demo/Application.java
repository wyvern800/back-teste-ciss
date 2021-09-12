package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EnableWebSecurity
    @Configuration
    static
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
            http.csrf().disable()
                    .anonymous().and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.PUT, "/funcionarios").permitAll()
                    .antMatchers(HttpMethod.DELETE, "/funcionarios").permitAll()
                    .antMatchers(HttpMethod.POST, "/funcionarios").permitAll()
                    .antMatchers(HttpMethod.GET, "/funcionarios").permitAll()
                    .and().cors().disable();
        }
    }
}
package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class Password {
    @Bean
    public BCryptPasswordEncoder pass(){
        return new BCryptPasswordEncoder();
    }
}

package com.example.webservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class ConfigClass {

    @Bean
    public AtomicInteger atomicInteger() {
        return new AtomicInteger();
    }
/*
    @Bean
    public Map<Integer, String> users() {
        return new HashMap<>();
    }*/

    @Bean
    public User user(){
        return new User();
    }

}

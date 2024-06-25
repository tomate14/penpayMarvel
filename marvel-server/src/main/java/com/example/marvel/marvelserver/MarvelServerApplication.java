package com.example.marvel.marvelserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.marvel.marvelserver", "com.example.marvel.marvelconsumer"})
public class MarvelServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarvelServerApplication.class, args);
    }

}

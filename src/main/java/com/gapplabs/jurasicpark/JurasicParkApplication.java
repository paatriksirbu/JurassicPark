package com.gapplabs.jurasicpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class JurasicParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(JurasicParkApplication.class, args);
    }
}


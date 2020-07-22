package com.garage.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.garage")
public class ApplicationAPI {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationAPI.class, args);
    }
}

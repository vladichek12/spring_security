package com.example.secutityapp;


import com.example.secutityapp.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.example.secutityapp.controller")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

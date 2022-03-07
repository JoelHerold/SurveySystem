package com.example.webanwendungumfragesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


//um die Login Seite später aufzurufen

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })

public class WebAnwendungUmfrageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAnwendungUmfrageSystemApplication.class, args);
    }

}

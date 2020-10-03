package com.acme.homehealthy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HomehealthyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomehealthyApplication.class, args);
    }

}

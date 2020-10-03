package com.acme.blogging;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sound.midi.SysexMessage;

@SpringBootApplication
@EnableJpaAuditing
public class BloggingApplication {
    public static void main(String[] args) {
        SpringApplication.run(BloggingApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}

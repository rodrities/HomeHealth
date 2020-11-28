package com.acme.homehealthy.security.controller;

import com.acme.homehealthy.security.domain.service.DefaultUserDetailsService;
import com.acme.homehealthy.security.resource.UserResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DefaultUserDetailsService userDetailsService;

    @GetMapping
    public List<UserResource> getAll() {
        return userDetailsService.getAll().stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
    }

    private UserResource convertToResource(User user) {
        return mapper.map(user, UserResource.class);
    }
}

package com.acme.homehealthy.controller;

import com.acme.homehealthy.domain.model.User;
import com.acme.homehealthy.domain.repository.UserRepository;
import com.acme.homehealthy.domain.service.UserService;
import com.acme.homehealthy.resource.SaveUserResource;
import com.acme.homehealthy.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Users", description = "Users API")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Page<UserResource> getAllUsers(Pageable pageable) {
        Page<User> postsPage = userService.getAllUsers(pageable);
        List<UserResource> resources = postsPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/users/{userId}")
    public UserResource getUserById(@PathVariable(value = "userId" ) Long userId) {
        return convertToResource(userService.getUserById(userId));
    }

    @GetMapping("/users/username/{username}")
    public UserResource getUserByUsername(@PathVariable(value = "username" ) String username) {
        return convertToResource(userService.getUserByUsername(username));
    }


    @PostMapping("/users")
    public UserResource createUser(@RequestBody SaveUserResource resource) {
        User user = convertToEntity(resource);
        return convertToResource(userService.createUser(user));
    }

    @PutMapping("/users/{userId}")
    public UserResource updateUser(@PathVariable Long userId,
                                   @RequestBody SaveUserResource resource) {
        User user = convertToEntity(resource);
        return convertToResource(
                userService.updatedUser(userId, user));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity) {
        return mapper.map(entity, UserResource.class);
    }

}

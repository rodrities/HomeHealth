package com.acme.blogging.domain.service;

import com.acme.blogging.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserService {

    Page<User> getAllUsers(Pageable pageable);

    User getUserById(Long userId);

    User createUser(User user);

    User updatedUser(Long userId, User userRequest);

    ResponseEntity<?> deleteUser(Long userId);

    User getUserByUsername(String username);

    User getUserByUsernameAndPassowrd(String name,String password);
}

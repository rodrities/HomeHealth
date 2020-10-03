package com.acme.blogging.service;


import com.acme.blogging.domain.model.User;
import com.acme.blogging.domain.repository.UserRepository;
import com.acme.blogging.domain.service.UserService;
import com.acme.blogging.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Id", userId));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updatedUser(Long userId, User userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Id", userId));
        return userRepository.save(
                user.setUsername(userRequest.getUsername())
                    .setPassword(userRequest.getPassword()));
    }

    @Override
    public ResponseEntity<?> deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Id", userId));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Username", username));
    }

    @Override
    public User getUserByUsernameAndPassowrd(String name, String password) {
        return userRepository.findByUsernameAndPassword(name,password)
                .orElseThrow(()->new ResourceNotFoundException("User", "Username or password",name + " " + password));
    }
}

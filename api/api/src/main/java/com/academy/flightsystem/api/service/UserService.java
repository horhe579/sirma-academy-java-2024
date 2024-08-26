package com.academy.flightsystem.api.service;

import com.academy.flightsystem.api.entity.User;
import com.academy.flightsystem.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId)
    {
        return this.userRepository.findById(userId);
    }

    public User createUser(User user)
    {
        return this.userRepository.save(user);
    }

    public User updateUser(Long userId, User updatedUser)
    {
        User user = this.userRepository.findById(userId).orElseThrow();
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setRoles(updatedUser.getRoles());
        return this.userRepository.save(user);
    }
//
//    public void deleteUserById(Long userId)
//    {
//        this.userRepository.deleteById(userId);
//    }
//
//    public void deleteUser(User user)
//    {
//        this.userRepository.delete(user);
//    }
}



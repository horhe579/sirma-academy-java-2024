package com.academy.flightsystem.api.controller;

import com.academy.flightsystem.api.entity.User;
import com.academy.flightsystem.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId)
    {
        return this.userService.getUserById(userId);
    }

    @GetMapping
    public Iterable<User> getAllUsers()
    {
        return this.userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return this.userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user)
    {
        return this.userService.updateUser(userId, user);
    }
//
//    @DeleteMapping("/{userId}")
//    public User deleteUser(@PathVariable Long userId)
//    {
//        return this.userService.deleteUser(userId);
//    }
}

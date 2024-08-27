package com.academy.flightsystem.api.controller;

import com.academy.flightsystem.api.entity.User;
import com.academy.flightsystem.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId)
    {
        return this.userService.getUserById(userId);
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers()
    {
        List<User> users = this.userService.getAllUsers();

        return ResponseEntity.ok(users);
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

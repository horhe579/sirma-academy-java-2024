package com.academy.flightsystem.api.controller;

import com.academy.flightsystem.api.dto.responses.GetUserResponseDTO;
import com.academy.flightsystem.api.entity.User;
import com.academy.flightsystem.api.security.jwt.JwtService;
import com.academy.flightsystem.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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

//    @GetMapping("/{userId}")
//    @PostAuthorize("@owner.apply(returnObject, principal.getId())")
//    public Optional<User> getUserById(@PathVariable Long userId)
//    {
//        return this.userService.getUserById(userId);
//    }

    @GetMapping("/{userId}")
    @PostAuthorize("hasAuthority('ADMIN') or @owner.apply(returnObject, principal.getId())")
    public Optional<GetUserResponseDTO> getUserById(@PathVariable Long userId)
    {
        User user = this.userService.getUserById(userId).orElseThrow();
        return Optional.of(new GetUserResponseDTO(user));
    }

    @GetMapping
    //check SPEL
    @PreAuthorize("hasAuthority('ADMIN')")
    // hasAuthority does not add "ROLE_" prefix before the authority,
    // so I can use this instead of hasRole, which adds a prefix
    // if I decided to use hasRole, the roles would have to be set
    // as ROLE_{ROLENAME} instead of {ROLENAME}
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
    @PostAuthorize("@owner.apply(returnObject, principal.getId())")
    public User updateUser(@PathVariable Long userId, @RequestBody User user)
    {
        return this.userService.updateUser(userId, user);
    }
//
//    @DeleteMapping("/{userId}")
//    @PostAuthorize("@owner.apply(returnObject, principal.getId())")

//    public User deleteUser(@PathVariable Long userId)
//    {
//        return this.userService.deleteUser(userId);
//    }
}

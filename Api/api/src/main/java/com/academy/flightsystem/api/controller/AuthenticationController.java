package com.academy.flightsystem.api.controller;

import com.academy.flightsystem.api.dto.LoginUserDTO;
import com.academy.flightsystem.api.dto.RegisterUserDTO;
import com.academy.flightsystem.api.security.jwt.JwtService;
import com.academy.flightsystem.api.service.AuthenticationService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import responses.LoginResponse;
import com.academy.flightsystem.api.entity.User;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDTO)
    {
        User registeredUser = authenticationService.signUp(registerUserDTO);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDTO)
    {
        User authenticatedUser = authenticationService.authenticate(loginUserDTO);
        String jwt = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwt);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}

package com.sirma.finalexam.matchanalyzer.controllers;

import com.sirma.finalexam.matchanalyzer.dtos.create.LoginUserDTO;
import com.sirma.finalexam.matchanalyzer.dtos.create.RegisterUserDTO;
import com.sirma.finalexam.matchanalyzer.dtos.response.LoginResponseDTO;
import com.sirma.finalexam.matchanalyzer.entities.User;
import com.sirma.finalexam.matchanalyzer.services.AuthenticationService;
import com.sirma.finalexam.matchanalyzer.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        User user = this.authenticationService.signup(registerUserDTO);
        //check if faulty response in case of invalid username or password
        //return bad request if it is
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginUserDTO loginUserDTO)
    {
        User authenticatedUser = this.authenticationService.authenticate(loginUserDTO);
        //error handling for no found user
        String jwt = this.jwtService.generateToken(authenticatedUser);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setToken(jwt);
        loginResponseDTO.setExpiresIn(this.jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponseDTO);
    }
}

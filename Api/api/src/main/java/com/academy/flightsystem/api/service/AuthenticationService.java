package com.academy.flightsystem.api.service;

import com.academy.flightsystem.api.dto.LoginUserDTO;
import com.academy.flightsystem.api.dto.RegisterUserDTO;
import com.academy.flightsystem.api.entity.User;
import com.academy.flightsystem.api.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;


    public AuthenticationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signUp(RegisterUserDTO input)
    {
        User user = new User();
        user.setUsername(input.getUsername());
        user.setPassword(this.passwordEncoder.encode(input.getPassword()));

        return this.userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword())
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}

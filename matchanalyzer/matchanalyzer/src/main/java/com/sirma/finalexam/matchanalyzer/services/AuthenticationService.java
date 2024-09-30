package com.sirma.finalexam.matchanalyzer.services;

import com.sirma.finalexam.matchanalyzer.dtos.create.LoginUserDTO;
import com.sirma.finalexam.matchanalyzer.dtos.create.RegisterUserDTO;
import com.sirma.finalexam.matchanalyzer.entities.User;
import com.sirma.finalexam.matchanalyzer.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserDTO registerUserDTO)
    {
        //some constraint for unique mails
        User user = new User();
        user.setFullName(registerUserDTO.getFullName());
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        user.setEmail(registerUserDTO.getEmail());

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO loginUserDTO)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserDTO.getEmail(),
                        loginUserDTO.getPassword()
                )
        );

        return userRepository.findByEmail(loginUserDTO.getEmail())
                .orElseThrow();
    }
}

package com.sirma.finalexam.matchanalyzer.dtos.create;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String email;

    private String password;

    private String fullName;
}
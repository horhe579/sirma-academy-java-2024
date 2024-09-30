package com.sirma.finalexam.matchanalyzer.dtos.response;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }
}

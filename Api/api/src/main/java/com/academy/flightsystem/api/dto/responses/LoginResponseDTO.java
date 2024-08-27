package com.academy.flightsystem.api.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {

    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }
}

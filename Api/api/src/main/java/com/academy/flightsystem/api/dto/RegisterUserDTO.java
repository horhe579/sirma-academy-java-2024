package com.academy.flightsystem.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {

    private String username;

    private String password;

}

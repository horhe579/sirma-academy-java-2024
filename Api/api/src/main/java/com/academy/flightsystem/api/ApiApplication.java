package com.academy.flightsystem.api;

import com.academy.flightsystem.api.security.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
public class ApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}

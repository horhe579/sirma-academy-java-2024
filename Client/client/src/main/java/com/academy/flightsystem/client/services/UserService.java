package com.academy.flightsystem.client.services;

import com.academy.flightsystem.client.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    //backend communication via url
    @Value("$backend.api.url")
    private String backendApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public void register(User user)
    {
        restTemplate.postForObject(backendApiUrl + "/users/register", user, User.class);
    }
}

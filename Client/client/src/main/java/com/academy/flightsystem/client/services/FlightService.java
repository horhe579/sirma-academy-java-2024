package com.academy.flightsystem.client.services;

import com.academy.flightsystem.client.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightService {
    @Value("$backend.api.url")
    private String backendApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<Flight> getAllFlights()
    {
        Flight[] flights = restTemplate.getForObject(backendApiUrl + "/flights", Flight[].class);
        return Arrays.stream(flights).toList();
    }

//    public Flight getFlightById(Long flightId)
//    {
//
//    }
}

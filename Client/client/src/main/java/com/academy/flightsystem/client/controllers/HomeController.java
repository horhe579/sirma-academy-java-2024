package com.academy.flightsystem.client.controllers;

import com.academy.flightsystem.client.models.Flight;
import com.academy.flightsystem.client.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    @GetMapping("/flights")
    public String getFlights(Model model)
    {
        //fetch all flights from api
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "flights";
    }
}

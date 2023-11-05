package com.example.weatherapijava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @PostMapping("/current")
    public String getCurrentWeather(@RequestParam("latitude") double latitude,
                                    @RequestParam("longitude") double longitude) {
        latitude = 25;
        longitude = 20;

        return "Current weather data for Latitude: " + latitude + ", Longitude: " + longitude;
    }
}

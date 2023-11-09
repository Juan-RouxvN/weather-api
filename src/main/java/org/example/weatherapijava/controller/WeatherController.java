package org.example.weatherapijava.controller;


import org.example.weatherapijava.model.WeatherData;
import org.example.weatherapijava.service.WeatherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.URISyntaxException;
import java.util.Optional;


@RestController
@EnableWebMvc
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(path = "/weather")
    public String getHello() throws URISyntaxException {
        return "Hello from application!";
    }

    @RequestMapping(path = "/api/weather/{lat}/{longi}")
    public Optional<WeatherData> postWeather(@PathVariable double lat, @PathVariable double longi) throws URISyntaxException {
        return Optional.ofNullable(weatherService.getWeatherData(lat, longi));
    }
}

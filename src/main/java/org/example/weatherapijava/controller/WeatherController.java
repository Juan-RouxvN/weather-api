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

    @RequestMapping(path = "/api/weather", method = RequestMethod.POST)
    public Optional<WeatherData> postWeather(@RequestBody WeatherRequest weatherRequest) throws URISyntaxException {
        return Optional.ofNullable(weatherService.getWeatherData(weatherRequest.latitude(), weatherRequest.longitude()));
    }

    protected static record WeatherRequest(double latitude, double longitude) { };
}

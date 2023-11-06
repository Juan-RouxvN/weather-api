package com.example.weatherapijava.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weatherapijava.model.WeatherData;

@Service
public class WeatherService {

    private final String API_URL = System.getenv("API_URL");
    private final String API_KEY = System.getenv("API_KEY");

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherData(double latitude, double longitude) {
        String apiUrl = String.format("%s?lat=%s&lon=%s&appid=%s", API_URL, latitude, longitude, API_KEY);
        return restTemplate.getForObject(apiUrl, WeatherData.class);
    }
}

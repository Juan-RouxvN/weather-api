package com.example.weatherapijava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherapijava.model.WeatherData;
import com.example.weatherapijava.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping(value = "/current", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WeatherData> getCurrentWeather(@RequestBody WeatherRequest weatherRequest) {
        return ResponseEntity.ok(weatherService.getWeatherData(weatherRequest.getLatitude(), weatherRequest.getLongitude()));
    }

    static class WeatherRequest {
        private double latitude;
        private double longitude;

        public double getLatitude() {
            return latitude;
        }
    
        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }
    
        public double getLongitude() {
            return longitude;
        }
    
        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }
}

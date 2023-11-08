package com.example.weatherapijava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.weatherapijava")
public class WeatherApiJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiJavaApplication.class, args);
	}

}

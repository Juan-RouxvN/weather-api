package com.weatherapijava;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URISyntaxException;

@Path("weather")
@ApplicationScoped
public class WeatherController {
    @Inject
    WeatherService weatherService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)    
    public Response postWeather(@QueryParam("lat") double latitude, @QueryParam("long") double longitude) throws URISyntaxException {
        return Response.ok(weatherService.getWeatherData(latitude, longitude)).build();
    }
}

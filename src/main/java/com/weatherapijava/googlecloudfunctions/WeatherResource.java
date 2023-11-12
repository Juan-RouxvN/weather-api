package com.weatherapijava.googlecloudfunctions;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Logger;

@Path("/api/weather")
@ApplicationScoped
public class WeatherResource {
    private static final Logger LOGGER = Logger.getLogger(WeatherResource.class.getName());

    @Inject
    WeatherService weatherService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response postWeather(@QueryParam("lat") double latitude, @QueryParam("long") double longitude) throws URISyntaxException {
        return Response.ok(weatherService.getWeatherData(latitude, longitude)).build();
    }
}

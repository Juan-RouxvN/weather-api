namespace WeatherAPI;

using Google.Cloud.Functions.Framework;
using Microsoft.AspNetCore.Http;
using System;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using WeatherAPI.Services;

public class Function : IHttpFunction
{
    public async Task HandleAsync(HttpContext context)
    {
        try
        {
            HttpRequest request = context.Request;
            if (request.Method == "POST")
            {
                var coordinates = JsonSerializer.Deserialize<Coordinates>(request.Body);
                var weatherService = new WeatherService(new HttpClient());
                var weatherData = await weatherService.GetWeatherDataAsync(coordinates.latitude, coordinates.longitude);
                await context.Response.WriteAsJsonAsync(weatherData);
            }
             await context.Response.WriteAsync("Unsupported Method used.");
        }
        catch (Exception ex)
        {
            // Log the error
            await context.Response.WriteAsync("Error fetching weather data");
        }
    }

    public record Coordinates(double latitude, double longitude);
}


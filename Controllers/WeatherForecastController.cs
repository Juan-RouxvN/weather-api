namespace WeatherAPI.Controllers;

using Microsoft.AspNetCore.Mvc;
using Microsoft.Azure.WebJobs;
using System.Net.Http;
using System.Threading.Tasks;
using WeatherAPI.Services;
using Microsoft.Azure.WebJobs.Extensions.Http;
using Microsoft.AspNetCore.Http;
using System.IO;
using System.Text.Json;
using System;
using System.Web.Http;

public class WeatherController
{
    private readonly WeatherService weatherService;

    public WeatherController(WeatherService service)
    {
        weatherService = service;
    }

    [FunctionName("WeatherController")]
    public async Task<IActionResult> Run([HttpTrigger(AuthorizationLevel.Anonymous, "weather")] HttpRequest req)
    {
        try
        {
            if (req.Method == HttpMethods.Post)
            {
                using StreamReader reader = new StreamReader(req.Body);
                string requestBody = await reader.ReadToEndAsync();

                var coordinates = JsonSerializer.Deserialize<Coordinates>(requestBody);
                var weatherData = await weatherService.GetWeatherDataAsync(coordinates.latitude, coordinates.longitude);

                return new OkObjectResult(weatherData);
            }

            return new OkObjectResult("Unsupported Method");
        }
        catch (Exception ex)
        {
            // Log the error
            return new InternalServerErrorResult();
        }
    }
}

public record Coordinates(double latitude, double longitude);

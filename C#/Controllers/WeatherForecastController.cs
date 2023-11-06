namespace WeatherAPI.Controllers;

using Microsoft.AspNetCore.Mvc;
using System.Net.Http;
using System.Threading.Tasks;
using WeatherAPI.Services;

[ApiController]
[Route("api/weather")]
public class WeatherController : ControllerBase
{
    private readonly WeatherService weatherService;

    public WeatherController(WeatherService service)
    {
        weatherService = service;
    }

    [HttpPost]
    public async Task<IActionResult> GetWeather([FromBody] Coordinates coordinates)
    {
        try
        {
            var weatherData = await weatherService.GetWeatherDataAsync(coordinates.latitude, coordinates.longitude);
            return Ok(weatherData);
        }
        catch (Exception ex)
        {
            // Log the error
            return StatusCode(500, "Error fetching weather data");
        }
    }
}

public record Coordinates(double latitude, double longitude);

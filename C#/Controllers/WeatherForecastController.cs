namespace WeatherService;

using Microsoft.AspNetCore.Mvc;
using System.Net.Http;
using System.Threading.Tasks;

[ApiController]
[Route("api/weather")]
public class WeatherController : ControllerBase
{
    // private readonly IHttpClientFactory _httpClientFactory;

    // public WeatherController(IHttpClientFactory httpClientFactory)
    // {
    //     _httpClientFactory = httpClientFactory;
    // }

    [HttpPost]
    public async Task<IActionResult> GetWeather()
    {
        // using var client = _httpClientFactory.CreateClient();

        // Use coordinates.Latitude and coordinates.Longitude to make API call to Open Weather or any weather service.
        // Example: var response = await client.GetAsync($"API_URL_WITH_COORDINATES");
        // Process weather response and return appropriate information.
        return Ok("Weather Information"); // Placeholder response
    }
}

public record Coordinates(double Latitude, double Longitude);

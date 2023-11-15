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

    [HttpGet]
    public async Task<IActionResult> GetWeather([FromQuery(Name = "lat")] string latitude, [FromQuery(Name = "long")] string longitude)
    {
        try
        {
            Console.WriteLine(latitude + "\n" + longitude);
            var weatherData = await weatherService.GetWeatherDataAsync(latitude, longitude);
            return Ok(weatherData);
        }
        catch (Exception ex)
        {
            // Log the error
            return StatusCode(500, "Error fetching weather data");
        }
    }
}

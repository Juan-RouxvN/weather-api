namespace WeatherAPI;

using Google.Cloud.Functions.Framework;
using Microsoft.AspNetCore.Http;
using System;
using System.IO;
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
            if (request.Method == HttpMethods.Get)
            {
                string latitude = request.QueryString["lat"];
                string longitude = request.QueryString["long"];
                var weatherService = new WeatherService(new HttpClient());
                var weatherData = await weatherService.GetWeatherDataAsync(latitude, longitude);
                await context.Response.WriteAsJsonAsync(weatherData);
            }
             await context.Response.WriteAsync("Unsupported Method used.");
        }
        catch (Exception ex)
        {
            // Log the error
            await context.Response.WriteAsync("Error fetching weather data: " + ex.Message);
        }
    }
}


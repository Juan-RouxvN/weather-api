using System;
using System.IO;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Azure.WebJobs;
using Microsoft.Azure.WebJobs.Extensions.Http;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;

using weather_app_csharp.models;

namespace weather_app_csharp
{
    public static class WeatherApp
    {
        private static readonly string API_URL = Environment.GetEnvironmentVariable("API_URL");

        private static readonly string API_KEY = Environment.GetEnvironmentVariable("API_KEY");

        static readonly HttpClient client = new HttpClient();

        [FunctionName("WeatherApp")]
        public static async Task<IActionResult> Run(
            [HttpTrigger(AuthorizationLevel.Anonymous, "get", Route = "weather")] HttpRequest req,
            ILogger log)
        {
            log.LogInformation("C# HTTP trigger function processed a request.");

            int lat = Convert.ToInt32(req.Query["lat"]);
            int longi = Convert.ToInt32(req.Query["long"]);

            string url = $"{API_URL}?lat={lat}&lon={longi}&appid={API_KEY}&units=metric";

            using HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();

            string stringResponse = await response.Content.ReadAsStringAsync();
            var weatherData = JsonConvert.DeserializeObject<WeatherData>(stringResponse);

            return new OkObjectResult(weatherData);
        }
    }
}

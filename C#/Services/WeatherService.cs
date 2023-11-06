namespace WeatherAPI.Services;

using System.Net.Http;
using System.Threading.Tasks;
using Newtonsoft.Json;

public class WeatherService
{
    private readonly HttpClient _httpClient;
    private string? API_URL = Environment.GetEnvironmentVariable("API_URL");
    private string? API_KEY = Environment.GetEnvironmentVariable("API_KEY");
    
    public WeatherService(HttpClient httpClient)
    {
        _httpClient = httpClient;
    }

    public async Task<WeatherData?> GetWeatherDataAsync(double latitude, double longitude)
    {
        Console.WriteLine(API_URL + "\n" + API_KEY + "\n" + latitude + "\n" + longitude);
        string apiUrl = $"{API_URL}?lat={latitude}&lon={longitude}&appid={API_KEY}&units=metric";
        HttpResponseMessage response = await _httpClient.GetAsync(apiUrl);

        string jsonResponse = await response.Content.ReadAsStringAsync();
        var weatherData = JsonConvert .DeserializeObject<WeatherData>(jsonResponse);
        return weatherData ?? null;
    }
}

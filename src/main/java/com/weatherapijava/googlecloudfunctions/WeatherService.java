package com.weatherapijava.googlecloudfunctions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapijava.googlecloudfunctions.WeatherData;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

@ApplicationScoped
public class WeatherService{
    private final String API_URL = System.getenv("API_URL");
    private final String API_KEY = System.getenv("API_KEY");

    public WeatherData getWeatherData(String latitude, String longitude) throws URISyntaxException {
        String apiUrl = String.format("%s?lat=%s&lon=%s&appid=%s", API_URL, latitude, longitude, API_KEY);
        WeatherData responseBody = null;


        HttpGet httpGet = new HttpGet(apiUrl);
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {

                HttpEntity entity = response.getEntity();
                // Get response information
                ObjectMapper objectMapper = new ObjectMapper();
                responseBody = objectMapper.readValue(EntityUtils.toString(entity), WeatherData.class);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return responseBody;
    }
}

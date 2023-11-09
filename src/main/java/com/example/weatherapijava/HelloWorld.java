package com.example.weatherapijava;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import com.example.weatherapijava.model.WeatherData;
import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.code.gson;

public class HelloWorld implements HttpFunction {
  private final String API_URL = System.getenv("API_URL");
  
  private final String API_KEY = System.getenv("API_KEY");

  private static final ObjectMapper objectMapper = new ObjectMapper();

  private final static HttpClient client =
      HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();

  public void service(final HttpRequest request, final HttpResponse response) throws Exception {
    WeatherRequest body = objectMapper.readValue(request.getReader(), WeatherRequest.class);
      String apiUrl = String.format("%s?lat=%s&lon=%s&appid=%s", API_URL, body.getLatitude(), body.getLongitude(), API_KEY);
      var getRequest = java.net.http.HttpRequest.newBuilder().uri(URI.create(apiUrl)).GET().build();
      var getResponse = client.send(getRequest, BodyHandlers.ofString());

      final BufferedWriter writer = response.getWriter();

      writer.write(String.valueOf(getResponse.body()));
  }

  private static class WeatherRequest {
      private double latitude;
      private double longitude;

      public void setLatitude(double latitude){
          this.latitude = latitude;
      }

      public double getLatitude(){
          return this.latitude;
      }

      public void setLongitude(double longitude){
          this.longitude = longitude;
      }

      public double getLongitude(){
          return this.longitude;
      }
  };
}


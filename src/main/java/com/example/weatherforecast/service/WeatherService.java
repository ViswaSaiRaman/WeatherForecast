package com.example.weatherforecast.service;
import com.example.weatherforecast.model.WeatherForecast;
import com.example.weatherforecast.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@Component
public class WeatherService     {

    @Value("${openWeather.API_KEY}")
    private String API_KEY;

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?zip={zip}&appid={apiKey}";
    private final RestTemplate restTemplate;


    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // The method body will only be executed if there is a cache miss
    // If there's a cache hit, the cached value will be returned directly
    @Cacheable(value = "weatherForecast", key = "#zipCode")
    public WeatherForecast getWeatherForecast(String zipCode, WeatherResponse response) {

        response.setFromCache(false);
        return getWeatherForecastAPI(zipCode);
    }

    public WeatherForecast getWeatherForecastAPI(String zipCode) {
        String url = BASE_URL.replace("{zip}", zipCode).replace("{apiKey}", API_KEY);
        return restTemplate.getForObject(url, WeatherForecast.class);
    }

}

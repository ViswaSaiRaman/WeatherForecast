package com.example.weatherforecast.controller;

import com.example.weatherforecast.model.WeatherForecast;
import com.example.weatherforecast.model.WeatherResponse;
import com.example.weatherforecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
@RequestMapping("/api/weather")
public class WeatherController {


    private final WeatherService weatherService;


    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{zipCode}")
    public WeatherResponse getWeather(@PathVariable String zipCode) {
        WeatherResponse response = new WeatherResponse(null,true);
        WeatherForecast weatherForecast = weatherService.getWeatherForecast(zipCode,response);
        response.setWeatherForecast(weatherForecast);

        return response;
    }
}

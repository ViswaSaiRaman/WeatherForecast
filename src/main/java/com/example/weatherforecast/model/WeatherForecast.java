package com.example.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {


    private String cityName;
    private double currentTemperature;
    private double highTemperature;
    private double lowTemperature;
    private double windSpeed;
    private String rainfall;


    public double getCurrentTemperature() {
        return currentTemperature;
    }


    public double getLowTemperature() {
        return lowTemperature;
    }



    public double getHighTemperature() {
        return highTemperature;
    }

    public String getCityName() {
        return cityName;
    }


    public double getWindSpeed() {
        return windSpeed;
    }

    public String getRainfall() {
        return rainfall;
    }


    @JsonProperty("name")
    public void setCityName(String name) {
        this.cityName = name;
    }

    @JsonProperty("main")
    public void setTemperature(Map<String,String> main) {
        this.highTemperature = Double.parseDouble(main.get("temp_max"));
        this.lowTemperature = Double.parseDouble(main.get("temp_min"));
        this.currentTemperature = Double.parseDouble(main.get("temp"));

    }

    @JsonProperty("wind")
    public void setWindSpeed(Map<String,String> wind) {
        this.windSpeed = Double.parseDouble(wind.get("speed"));
    }

    @JsonProperty("weather")
    public void setRainfall(List<Map<String,String>> weather) {
        this.rainfall = weather.get(0).get("description");
    }


}
package com.example.weatherforecast.model;

public class WeatherResponse {
    private  WeatherForecast weatherForecast;
    private boolean fromCache;

    public WeatherResponse(WeatherForecast weatherForecast, boolean fromCache) {
        this.weatherForecast = weatherForecast;
        this.fromCache = fromCache;
    }

    public WeatherForecast getWeatherForecast() {
        return weatherForecast;
    }

    public boolean isFromCache() {
        return fromCache;
    }

    public void setFromCache(Boolean bool)
    {
        this.fromCache=bool;
    }

    public void setWeatherForecast(WeatherForecast weatherForecast)
    {
        this.weatherForecast=weatherForecast;
    }

}


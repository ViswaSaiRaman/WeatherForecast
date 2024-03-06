package com.example.weatherforecast.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.core.env.Environment;

import java.util.concurrent.TimeUnit;
@Configuration
@EnableCaching
public class CacheConfig {


    @Value("${caffeine.expireAfterWrite}")
    private String expireAfterWrite;
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("weatherForecast");
        System.out.println(expireAfterWrite);
        cacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite( Long.parseLong(expireAfterWrite) , TimeUnit.MINUTES));
        return cacheManager;
    }
}
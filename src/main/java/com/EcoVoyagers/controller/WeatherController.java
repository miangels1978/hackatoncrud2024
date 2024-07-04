package com.EcoVoyagers.controller;

import com.EcoVoyagers.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping(path = "/weather")
    public String getWeatherData() {
        return weatherService.getWeatherData();
    }
}

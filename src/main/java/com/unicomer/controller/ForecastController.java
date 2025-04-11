package com.unicomer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicomer.dto.request.ForecastRequest;
import com.unicomer.service.ForecastService;

@RestController
@RequestMapping("/api")
public class ForecastController {

    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @PostMapping("/forecast")
    public ResponseEntity<?> getForecast(@RequestBody ForecastRequest request) {
        System.out.println("Ciudad recibida: " + request.getCity()); 
        double temperatura = forecastService.consultarTemperatura(request.getCity());
        return ResponseEntity.ok(temperatura);
    }

}

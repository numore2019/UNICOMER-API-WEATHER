package com.unicomer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.unicomer.dto.response.WeatherResponse;
import com.unicomer.dto.response.WeatherResponse.Forecast.ForecastDay;

@Service
public class ForecastService {

    @Value("${service.weatherapi.url}")
    private String url;
    
    @Value("${service.weatherapi.apikey}")
    private String apikey;

    private final RestTemplate restTemplate = new RestTemplate();

    public double consultarTemperatura(String ciudad) {
        // Construimos la peticion
        String uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key", apikey)
                .queryParam("q", ciudad)
                .queryParam("days", 1) // Dia siguiente a consultar
                .build()
                .toUriString();

        try {
            WeatherResponse weatherResponse = restTemplate.getForObject(uri, WeatherResponse.class);
            
            if (weatherResponse != null && weatherResponse.getForecast() != null &&
                weatherResponse.getForecast().getForecastday() != null &&
                !weatherResponse.getForecast().getForecastday().isEmpty()) {

                ForecastDay day = weatherResponse.getForecast().getForecastday().get(0);
                return day.getDay().getAvgtemp_c();  // Obtenemos avg temp
            } else {
                System.err.println("La respuesta de la API no contiene un dato valido.");
            }
        } catch (Exception e) {
            System.err.println("Error al consultar la temperatura: " + e.getMessage());
        }
        
        return 0.0; //
    }
}

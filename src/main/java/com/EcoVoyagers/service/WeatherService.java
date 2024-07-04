package com.EcoVoyagers.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    // La URL completa de la API de AEMET, incluyendo la clave de API
    private static final String AEMET_API_URL = "https://opendata.aemet.es/opendata/api/valores/climatologicos/inventarioestaciones/todasestaciones/";
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlaW5zdGVpbnZpZUBnbWFpbC5jb20iLCJqdGkiOiJkMjliYzg1NS0zOTRjLTRmMzAtOWFmYi05OTJhNTFkMWNmNWMiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTcyMDAxNjg3NSwidXNlcklkIjoiZDI5YmM4NTUtMzk0Yy00ZjMwLTlhZmItOTkyYTUxZDFjZjVjIiwicm9sZSI6IiJ9.X_g1jhVJpYCq55Cdiy1hRxS8_ZNO8m4KlTBvcU8UNb8";  // Reemplaza con tu clave de API

    public String getWeatherData() {
        String url = AEMET_API_URL + "?api_key=" + API_KEY;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            request.addHeader("cache-control", "no-cache");

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity); // Retorna el cuerpo de la respuesta en caso de éxito
                } else {
                    return "Error: No data found";
                }
            }
        } catch (Exception e) {
            return "Exception occurred: " + e.getMessage();
        }
    }
}

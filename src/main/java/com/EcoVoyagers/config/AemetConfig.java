package com.EcoVoyagers.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AemetConfig {
    @Value("${aemet.api.url}")
    private String apiUrl;

    @Value("${aemet.api.key}")
    private String apiKey;

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}

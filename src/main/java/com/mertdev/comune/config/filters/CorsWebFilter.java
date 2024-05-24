package com.mertdev.comune.config.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
@Component
@AllArgsConstructor
public class CorsWebFilter {

    public static CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Tek bir köken belirtildi
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE","PUT"));
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization")); // İstenilen başlıklar eklendi

        configuration.setAllowCredentials(true); // Kimlik bilgilerinin gönderilmesine izin verildi
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
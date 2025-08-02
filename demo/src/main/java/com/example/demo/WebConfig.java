package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // Cette annotation marque la classe comme une configuration Spring
public class WebConfig implements WebMvcConfigurer {

    // Cette méthode va configurer les règles CORS pour toutes les routes de l'application
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Appliquer la configuration CORS à toutes les routes
        registry.addMapping("/**")  // Applique à toutes les routes de l'application
                .allowedOrigins("http://frontend.local")  // Permet les requêtes de frontend.local
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Permet les méthodes HTTP
                .allowedHeaders("Content-Type");  // Permet l'en-tête Content-Type
    }
}

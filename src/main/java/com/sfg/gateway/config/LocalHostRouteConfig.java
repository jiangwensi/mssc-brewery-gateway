package com.sfg.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jiang Wensi on 11/11/2020
 */
@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder) {
        String uuidPattern = "[a-zA-Z0-9-]*";
        return builder.routes()
                .route(r -> r.path("/api/v1/beer", "/api/v1/beer/*", "/api/v1/beerUpc/*").uri("http://localhost:8080").id("beer-service"))
                .route(r -> r.path("/api/v1/customers/**").uri("http://localhost:8081").id("beer-order-service"))
                .build();
    }
}

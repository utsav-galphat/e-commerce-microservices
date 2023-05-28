package com.utech.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean                           /* the bean will be created with method name */
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}

package com.utech.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean                           /* the bean will be created with method name */
    @LoadBalanced                   /* enable client side load balancing */
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}

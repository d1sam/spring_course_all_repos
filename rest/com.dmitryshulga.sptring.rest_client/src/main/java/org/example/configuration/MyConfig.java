package org.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("org.example")
public class MyConfig {
    @Bean// бин для совершения http запросов из rest клиента
    public RestTemplate restTemplate(){// RestTemplate предоставляет спринг
        return new RestTemplate();
    }
}

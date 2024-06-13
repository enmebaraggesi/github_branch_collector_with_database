package com.github_branch_collector_with_database.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Value("${github.api.url}")
    String githubApiUrl;
    
    @Bean
    public WebClient webClient() {
        return WebClient.create(githubApiUrl);
    }
}

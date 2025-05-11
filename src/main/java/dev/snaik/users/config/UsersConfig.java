package dev.snaik.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class UsersConfig {
    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }
}

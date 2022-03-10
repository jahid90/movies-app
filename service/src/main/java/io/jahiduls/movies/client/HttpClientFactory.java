package io.jahiduls.movies.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class HttpClientFactory {

    public WebClient webClientOf(final String baseUrl) {
        return WebClient.builder().baseUrl(baseUrl).build();
    }

}

package io.jahiduls.movies.services.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.jahiduls.movies.client.HttpClientFactory;
import io.jahiduls.movies.configuration.TmdbConfiguration;
import io.jahiduls.movies.services.model.Movie;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class MoviesDiscovery {

    @ToString
    @Component
    @RequiredArgsConstructor
    public static class Request {

        private final TmdbConfiguration tmdbConfiguration;
        private final HttpClientFactory clientFactory;

        private static final String BASE_URL = "https://api.themoviedb.org/3";
        private static final String DISCOVERY_PATH = "/discover/movie";

        public Mono<Response> execute() {

            final WebClient webClient = clientFactory.webClientOf(BASE_URL + DISCOVERY_PATH);

            return webClient.get()
                    .uri(uriBuilder -> uriBuilder.queryParam("api_key", tmdbConfiguration.token()).build())
                    .retrieve()
                    .bodyToMono(Response.class);
        }
    }

    @Getter
    @ToString
    @JsonNaming(SnakeCaseStrategy.class)
    public static final class Response {
        private Integer page;
        private Integer totalPages;
        private Integer totalResults;
        private List<Movie> results;
    }

}

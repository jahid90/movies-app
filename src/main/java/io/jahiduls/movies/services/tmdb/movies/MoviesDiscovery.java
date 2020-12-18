package io.jahiduls.movies.services.tmdb.movies;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.jahiduls.movies.services.model.Movie;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import reactor.core.publisher.Mono;

public class MoviesDiscovery {

    @ToString
    @RequiredArgsConstructor
    public static class Request {

        private final RequestHeadersSpec<?> request;

        public Mono<Response> execute() {

            return request.retrieve()
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

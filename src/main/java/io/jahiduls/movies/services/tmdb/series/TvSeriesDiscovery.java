package io.jahiduls.movies.services.tmdb.series;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.jahiduls.movies.services.model.TvSeries;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import reactor.core.publisher.Mono;

public class TvSeriesDiscovery {

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
    public static class Response {
        private Integer page;
        private Integer totalPages;
        private Integer totalResults;
        private List<TvSeries> results;
    }

}

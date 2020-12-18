package io.jahiduls.movies.services.tmdb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoviesDiscoveryRequestBuilder {

    private final MoviesDiscovery.Request request;

    public MoviesDiscovery.Request build() {
        return request;
    }

}

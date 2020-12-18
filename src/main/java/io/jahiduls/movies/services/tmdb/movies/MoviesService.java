package io.jahiduls.movies.services.tmdb.movies;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoviesService {

    private final MoviesDiscoveryRequestBuilder discoveryRequestBuilder;

    public MoviesDiscoveryRequestBuilder discoveryRequestBuilder() {
        return discoveryRequestBuilder;
    }

}

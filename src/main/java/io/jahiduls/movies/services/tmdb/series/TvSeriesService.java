package io.jahiduls.movies.services.tmdb.series;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TvSeriesService {

    private final TvSeriesDiscoveryRequestBuilder discoveryRequestBuilder;

    public TvSeriesDiscoveryRequestBuilder discoveryRequestBuilder() {
        return discoveryRequestBuilder;
    }
}

package io.jahiduls.movies.controller;

import io.jahiduls.movies.services.tmdb.series.TvSeriesDiscovery;
import io.jahiduls.movies.services.tmdb.series.TvSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/series")
@RequiredArgsConstructor
public class TvSeriesController {

    private final TvSeriesService service;

    @GetMapping(value = "/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TvSeriesDiscovery.Response> discover() {
        return service.discoveryRequestBuilder().build().execute();
    }

}

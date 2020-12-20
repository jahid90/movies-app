package io.jahiduls.movies.controller;

import io.jahiduls.movies.configuration.Routes;
import io.jahiduls.movies.services.tmdb.series.discovery.Response;
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
@RequestMapping(Routes.SERIES_ROOT)
@RequiredArgsConstructor
public class TvSeriesController {

    private final TvSeriesService service;

    @GetMapping(value = Routes.POPULAR_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response> discover() {
        return service.getPopular();
    }

}

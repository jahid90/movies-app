package io.jahiduls.movies.controller;

import io.jahiduls.movies.services.tmdb.movies.discovery.Response;
import io.jahiduls.movies.services.tmdb.movies.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MoviesService service;

    @GetMapping(value = "/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response> popular() {
        return service.getPopular();
    }

}

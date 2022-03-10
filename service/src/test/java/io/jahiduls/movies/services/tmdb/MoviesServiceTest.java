package io.jahiduls.movies.services.tmdb;

import static org.assertj.core.api.Assertions.assertThat;

import io.jahiduls.movies.services.tmdb.movies.MoviesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.context.ApplicationContext;

public class MoviesServiceTest {

    private MoviesService service;

    @Mock private ApplicationContext context;

    @BeforeEach
    void setUp() {
        service = new MoviesService(context);
    }

    @Test
    void providesDiscovery() {
        assertThat(service).isNotNull();
    }
}

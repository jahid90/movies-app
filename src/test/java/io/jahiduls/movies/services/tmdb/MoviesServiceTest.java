package io.jahiduls.movies.services.tmdb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class MoviesServiceTest {

    private MoviesService service;

    @Mock private MoviesDiscoveryRequestBuilder builder;

    @BeforeEach
    void setUp() {
        service = new MoviesService(builder);
    }

    @Test
    void providesDiscovery() {
        assertThat(service).isNotNull();
    }
}

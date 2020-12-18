package io.jahiduls.movies.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TmdbConfiguration {

    private static final String BASE_URL = "https://api.themoviedb.org/3";
    @Value("${OMDB_API_KEY}") private String token;

    public String token() {
        return token;
    }

    public String baseUrl() {
        return BASE_URL;
    }

}


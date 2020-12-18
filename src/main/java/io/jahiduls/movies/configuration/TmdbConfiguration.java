package io.jahiduls.movies.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TmdbConfiguration {

    @Value("${OMDB_API_KEY}")
    private String token;

    public String token() {
        return token;
    }

}


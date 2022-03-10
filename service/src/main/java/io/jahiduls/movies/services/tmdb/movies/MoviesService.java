package io.jahiduls.movies.services.tmdb.movies;

import io.jahiduls.movies.services.tmdb.movies.discovery.Request;
import io.jahiduls.movies.services.tmdb.movies.discovery.RequestBuilder;
import io.jahiduls.movies.services.tmdb.movies.discovery.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MoviesService {

    private final ApplicationContext context;

    public Mono<Response> getPopular() {

        final RequestBuilder builder = context.getBean(RequestBuilder.class);
        final Request request = builder.newRequest()
                .sortByDefault()
                .withPage(1)
                .build();

        return request.execute();
    }

}

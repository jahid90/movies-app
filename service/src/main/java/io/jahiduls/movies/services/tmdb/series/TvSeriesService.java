package io.jahiduls.movies.services.tmdb.series;

import io.jahiduls.movies.services.tmdb.series.discovery.Request;
import io.jahiduls.movies.services.tmdb.series.discovery.RequestBuilder;
import io.jahiduls.movies.services.tmdb.series.discovery.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TvSeriesService {

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

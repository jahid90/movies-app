package io.jahiduls.movies.services.tmdb.movies.discovery;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import reactor.core.publisher.Mono;

@ToString
@RequiredArgsConstructor
public class Request {

    private final RequestBuilder builder;

    public Mono<Response> execute() {

        final WebClient webClient = builder.getWebClient();
        final UriComponents uriComponents = builder.getUriComponents();

        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParams(uriComponents.getQueryParams()).build())
                .retrieve()
                .bodyToMono(Response.class);
    }

}

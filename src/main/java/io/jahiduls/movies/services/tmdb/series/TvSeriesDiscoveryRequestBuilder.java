package io.jahiduls.movies.services.tmdb.series;

import io.jahiduls.movies.client.HttpClientFactory;
import io.jahiduls.movies.configuration.TmdbConfiguration;
import io.jahiduls.movies.services.tmdb.series.TvSeriesDiscovery.Request;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

@Component
@RequiredArgsConstructor
public class TvSeriesDiscoveryRequestBuilder {

    private static final String DISCOVERY_PATH = "/discover/tv";
    private static final String QUERY_API_KEY = "api_key";
    private static final String QUERY_PAGE = "page";

    private final TmdbConfiguration tmdbConfiguration;
    private final HttpClientFactory clientFactory;

    private MultiValueMap<String, String> queryParams;

    @PostConstruct
    private void configure() {

        queryParams = new LinkedMultiValueMap<>();
        queryParams.add(QUERY_API_KEY, tmdbConfiguration.token());
    }

    public TvSeriesDiscoveryRequestBuilder withPage(final int page) {

        queryParams.add(QUERY_PAGE, "" + page);

        return this;
    }

    public TvSeriesDiscovery.Request build() {

        final WebClient webClient = clientFactory.webClientOf(tmdbConfiguration.baseUrl() + DISCOVERY_PATH);

        final RequestHeadersSpec<?> requestSpec = webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParams(queryParams).build())
                .accept(MediaType.APPLICATION_JSON);

        return new Request(requestSpec);
    }
}

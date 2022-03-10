package io.jahiduls.movies.services.tmdb.series.discovery;

import io.jahiduls.movies.client.HttpClientFactory;
import io.jahiduls.movies.configuration.BeanName;
import io.jahiduls.movies.configuration.TmdbConfiguration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component(value = BeanName.SERIES_DISCOVERY_REQUEST_BUILDER)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class RequestBuilder implements FirstStep, SortByStep, PageStep, BuilderStep {

    private static final String DISCOVERY_PATH = "/discover/tv";

    private final TmdbConfiguration tmdbConfiguration;
    private final HttpClientFactory clientFactory;

    private UriComponentsBuilder uriComponentsBuilder;

    @Getter private UriComponents uriComponents;
    @Getter private WebClient webClient;

    @Override
    public SortByStep newRequest() {

        uriComponentsBuilder = UriComponentsBuilder.newInstance();
        uriComponentsBuilder.queryParam(QueryParam.API_KEY, tmdbConfiguration.token());

        webClient = clientFactory.webClientOf(tmdbConfiguration.baseUrl() + DISCOVERY_PATH);

        return this;
    }

    @Override
    public PageStep sortByDefault() {
        return sortByPopularityDesc();
    }

    @Override
    public PageStep sortByPopularityAsc() {
        uriComponentsBuilder.queryParam(QueryParam.SORT_BY, SortOrder.POPULARITY_ASC);
        return this;
    }

    @Override
    public PageStep sortByPopularityDesc() {
        uriComponentsBuilder.queryParam(QueryParam.SORT_BY, SortOrder.POPULARITY_DESC);
        return this;
    }

    @Override
    public PageStep sortByVoteAverageAsc() {
        uriComponentsBuilder.queryParam(QueryParam.SORT_BY, SortOrder.VOTE_AVERAGE_ASC);
        return this;
    }

    @Override
    public PageStep sortByVoteAverageDesc() {
        uriComponentsBuilder.queryParam(QueryParam.SORT_BY, SortOrder.VOTE_AVERAGE_DESC);
        return this;
    }

    @Override
    public PageStep sortByFirstAirDateAsc() {
        uriComponentsBuilder.queryParam(QueryParam.SORT_BY, SortOrder.FIRST_AIR_DATE_ASC);
        return this;
    }

    @Override
    public PageStep sortByFirstAirDateDesc() {
        uriComponentsBuilder.queryParam(QueryParam.SORT_BY, SortOrder.FIRST_AIR_DATE_DESC);
        return this;
    }

    @Override
    public BuilderStep withPage(final int page) {
        uriComponentsBuilder.queryParam(QueryParam.PAGE, "" + page);
        return this;
    }

    @Override
    public Request build() {
        uriComponents = uriComponentsBuilder.build();
        return new Request(this);
    }

}

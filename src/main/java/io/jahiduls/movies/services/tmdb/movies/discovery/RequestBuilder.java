package io.jahiduls.movies.services.tmdb.movies.discovery;

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

@Component(value = BeanName.MOVIES_DISCOVERY_REQUEST_BUILDER)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class RequestBuilder implements FirstStep, SortByStep, PageStep, BuilderStep {

    private static final String DISCOVERY_PATH = "/discover/movie";

    private final TmdbConfiguration tmdbConfiguration;
    private final HttpClientFactory clientFactory;

    private UriComponentsBuilder uriBuilder;

    @Getter private UriComponents uriComponents;
    @Getter private WebClient webClient;

    @Override
    public SortByStep newRequest() {

        webClient = clientFactory.webClientOf(tmdbConfiguration.baseUrl() + DISCOVERY_PATH);

        uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.queryParam(QueryParam.API_KEY, tmdbConfiguration.token());

        return this;
    }

    @Override
    public PageStep sortByDefault() {
        return sortByPopularityDesc();
    }

    @Override
    public PageStep sortByPopularityAsc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.POPULARITY_ASC);
        return this;
    }

    @Override
    public PageStep sortByPopularityDesc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.POPULARITY_DESC);
        return this;
    }

    @Override
    public PageStep sortByReleaseDateAsc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.RELEASE_DATE_ASC);
        return this;
    }

    @Override
    public PageStep sortByReleaseDateDesc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.RELEASE_DATE_DESC);
        return this;
    }

    @Override
    public PageStep sortByRevenueAsc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.REVENUE_ASC);
        return this;
    }

    @Override
    public PageStep sortByRevenueDesc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.REVENUE_DESC);
        return this;
    }

    @Override
    public PageStep sortByPrimaryReleaseDateAsc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.PRIMARY_RELEASE_DATE_ASC);
        return this;
    }

    @Override
    public PageStep sortByPrimaryReleaseDateDesc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.PRIMARY_RELEASE_DATE_DESC);
        return this;
    }

    @Override
    public PageStep sortByOriginalTitleAsc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.ORIGINAL_TITLE_ASC);
        return this;
    }

    @Override
    public PageStep sortByOriginalTitleDesc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.ORIGINAL_TITLE_DESC);
        return this;
    }

    @Override
    public PageStep sortByVoteAverageAsc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.VOTE_AVERAGE_ASC);
        return this;
    }

    @Override
    public PageStep sortByVoteAverageDesc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.VOTE_AVERAGE_DESC);
        return this;
    }

    @Override
    public PageStep sortByVoteCountAsc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.VOTE_COUNT_ASC);
        return this;
    }

    @Override
    public PageStep sortByVoteCountDesc() {
        uriBuilder.queryParam(QueryParam.SORT_BY, SortOrder.VOTE_COUNT_DESC);
        return this;
    }

    @Override
    public BuilderStep withPage(final int page) {
        uriBuilder.queryParam(QueryParam.PAGE, "" + page);
        return this;
    }

    @Override
    public Request build() {
        uriComponents = uriBuilder.build();
        return new Request(this);
    }

}

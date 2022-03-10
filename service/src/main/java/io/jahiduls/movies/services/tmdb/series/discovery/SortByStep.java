package io.jahiduls.movies.services.tmdb.series.discovery;

public interface SortByStep {

    PageStep sortByDefault();
    PageStep sortByPopularityAsc();
    PageStep sortByPopularityDesc();
    PageStep sortByVoteAverageAsc();
    PageStep sortByVoteAverageDesc();
    PageStep sortByFirstAirDateAsc();
    PageStep sortByFirstAirDateDesc();
    Request build();

}

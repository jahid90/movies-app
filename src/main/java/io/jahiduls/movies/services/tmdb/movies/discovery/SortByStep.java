package io.jahiduls.movies.services.tmdb.movies.discovery;

public interface SortByStep {

    PageStep sortByDefault();
    PageStep sortByPopularityAsc();
    PageStep sortByPopularityDesc();
    PageStep sortByReleaseDateAsc();
    PageStep sortByReleaseDateDesc();
    PageStep sortByRevenueAsc();
    PageStep sortByRevenueDesc();
    PageStep sortByPrimaryReleaseDateAsc();
    PageStep sortByPrimaryReleaseDateDesc();
    PageStep sortByOriginalTitleAsc();
    PageStep sortByOriginalTitleDesc();
    PageStep sortByVoteAverageAsc();
    PageStep sortByVoteAverageDesc();
    PageStep sortByVoteCountAsc();
    PageStep sortByVoteCountDesc();

}

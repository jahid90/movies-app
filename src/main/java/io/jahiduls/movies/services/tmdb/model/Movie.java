package io.jahiduls.movies.services.tmdb.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonNaming(SnakeCaseStrategy.class)
public final class Movie {

    private Integer id;
    private String title;
    private String overview;
    private String originalTitle;
    private Double popularity;
    private Integer voteCount;
    private Double voteAverage;
    private Boolean adult;
    private Boolean video;
    private String posterPath;
    private String backdropPath;
    private String releaseDate;
    private String originalLanguage;
    private Integer[] genreIds;

}

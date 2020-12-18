package io.jahiduls.movies.services.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonNaming(SnakeCaseStrategy.class)
public final class Movie {

    private String posterPath;
    private Boolean adult;
    private String overview;
    private String releaseDate;
    private Integer[] genreIds;
    private Integer id;
    private String originalTitle;
    private String originalLanguage;
    private String title;
    private String backdropPath;
    private Double popularity;
    private Integer voteCount;
    private Boolean video;
    private Double voteAverage;

}

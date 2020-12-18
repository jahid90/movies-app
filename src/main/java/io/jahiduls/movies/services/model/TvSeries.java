package io.jahiduls.movies.services.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonNaming(SnakeCaseStrategy.class)
public class TvSeries {

    private Integer id;
    private String name;
    private String originalName;
    private String overview;
    private Double popularity;
    private Integer voteCount;
    private Double voteAverage;
    private String posterPath;
    private String backdropPath;
    private String firstAirDate;
    private String originalLanguage;
    private List<String> originCountry;
    private List<Integer> genreIds;

}

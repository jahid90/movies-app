package io.jahiduls.movies.services.tmdb.movies.discovery;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.jahiduls.movies.services.tmdb.model.Movie;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonNaming(SnakeCaseStrategy.class)
public final class Response {

    private Integer page;
    private Integer totalPages;
    private Integer totalResults;
    private List<Movie> results;

}

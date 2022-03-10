package io.jahiduls.movies.services.tmdb.series.discovery;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.jahiduls.movies.services.tmdb.model.TvSeries;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonNaming(SnakeCaseStrategy.class)
public class Response {

    private Integer page;
    private Integer totalPages;
    private Integer totalResults;
    private List<TvSeries> results;

}

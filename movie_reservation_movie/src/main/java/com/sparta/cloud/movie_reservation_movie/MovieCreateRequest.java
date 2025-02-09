package com.sparta.cloud.movie_reservation_movie;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MovieCreateRequest {
    private String title;
    private String description;
    private String director;
    private String genre;
    private String actor;
    private LocalDateTime releaseDate;
    private LocalDateTime closeDate;
}

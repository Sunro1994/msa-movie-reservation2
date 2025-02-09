package com.sparta.cloud.movie_reservation_movie;

import com.sparta.cloud.movie_reservation_movie.core.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

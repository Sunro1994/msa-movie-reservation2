package com.sparta.cloud.movie_reservation_movie.repository;


import com.sparta.cloud.movie_reservation_movie.MovieResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomMovieRepository {

    Page<MovieResponse> getMovies(Pageable pageable);
}

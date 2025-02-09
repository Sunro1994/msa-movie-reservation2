package com.sparta.cloud.movie_reservation_movie.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.cloud.movie_reservation_movie.MovieResponse;
import com.sparta.cloud.movie_reservation_movie.core.QMovie;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.sparta.cloud.movie_reservation_movie.core.QMovie.*;

@RequiredArgsConstructor
public class MovieRepositoryImpl implements CustomMovieRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<MovieResponse> getMovies(Pageable pageable) {
        return queryFactory.selectFrom(movie)
                .fetch();
    }
}

package com.sparta.cloud.movie_reservation_movie;

import com.sparta.cloud.movie_reservation_movie.client.UserClient;
import com.sparta.cloud.movie_reservation_movie.core.Movie;
import com.sparta.cloud.movie_reservation_movie.repository.CustomMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final CustomMovieRepository customMovieRepository;
    private final UserClient userClient;
    private final MovieRepository movieRepository;

    @Transactional
    public void create(String userId, String role, MovieCreateRequest movieCreateRequest) {
        if (role != null && role.equals("ADMIN")) {
            Movie movie = Movie.toMovie(movieCreateRequest);
            movieRepository.save(movie);
        }else{
            throw new IllegalArgumentException("관리자만 영화를 등록할 수 있습니다.");
        }
    }

    @Transactional
    public void update(String userId, String role, MovieUpdateRequest movieUpdateRequest) {
        if (role != null && role.equals("ADMIN")) {
            Movie movie = movieRepository.findById(Long.valueOf(movieUpdateRequest.getMovieId()))
                    .orElseThrow(
                            () -> new IllegalArgumentException("존재하는 영화가 없습니다.")
                    );
            movie.update(movieUpdateRequest);
        }
    }

    public Page<MovieResponse> getMovies(Pageable pageable) {
        return customMovieRepository.getMovies(pageable);
    }
}

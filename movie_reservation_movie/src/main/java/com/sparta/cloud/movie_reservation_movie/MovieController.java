package com.sparta.cloud.movie_reservation_movie;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-Role") String role,
            @RequestBody MovieCreateRequest movieCreateRequest
    ){
        movieService.create(userId,role,movieCreateRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> update(
            @RequestHeader("X-User-Id") String userId,
            @RequestHeader("X-Role") String role,
            @RequestBody MovieUpdateRequest movieUpdateRequest
    ){
        movieService.update(userId,role,movieUpdateRequest);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Void> getMovies(
            Pageable pageable
    ){
        movieService.getMovies(pageable);
        return ResponseEntity.ok().build();
    }
}

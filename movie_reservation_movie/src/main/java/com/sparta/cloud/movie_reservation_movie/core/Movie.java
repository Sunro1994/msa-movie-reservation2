package com.sparta.cloud.movie_reservation_movie.core;

import com.sparta.cloud.movie_reservation_movie.MovieCreateRequest;
import com.sparta.cloud.movie_reservation_movie.MovieUpdateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("is_deleted = false")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private String genre;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String actor;


    private LocalDateTime releaseDate;

    private LocalDateTime closeDate;

    @SoftDelete(columnName = "is_deleted")
    @Builder.Default
    private Boolean isDeleted = Boolean.FALSE;

    @CreatedDate
    private LocalDateTime createDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updateDate;

    public static Movie toMovie(MovieCreateRequest movieCreateRequest) {
        return Movie.builder()
                .title(movieCreateRequest.getTitle())
                .description(movieCreateRequest.getDescription())
                .genre(movieCreateRequest.getGenre())
                .director(movieCreateRequest.getDirector())
                .actor(movieCreateRequest.getActor())
                .releaseDate(movieCreateRequest.getReleaseDate())
                .closeDate(movieCreateRequest.getCloseDate())
                .build();
    }

    public void update(MovieUpdateRequest movieUpdateRequest) {
        this.title = movieUpdateRequest.getTitle();
        this.description = movieUpdateRequest.getDescription();
        this.genre = movieUpdateRequest.getGenre();
        this.director = movieUpdateRequest.getDirector();
        this.actor = movieUpdateRequest.getActor();
        this.releaseDate = movieUpdateRequest.getReleaseDate();
        this.closeDate = movieUpdateRequest.getCloseDate();
    }
}

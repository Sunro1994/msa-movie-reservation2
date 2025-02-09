package com.sparta.cloud.movie_reservation_movie.client;

import com.sparta.cloud.movie_reservation_user.core.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/user/my")
    UserResponse getUser(@RequestHeader("X-User-Id") String userId);

}

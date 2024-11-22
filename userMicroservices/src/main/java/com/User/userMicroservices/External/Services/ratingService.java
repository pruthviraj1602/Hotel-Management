package com.User.userMicroservices.External.Services;

import com.User.userMicroservices.Entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATINGMICROSERVICE")
public interface ratingService {

    @GetMapping("/rating/getUserRating/{userId}")
    public ResponseEntity<List<Rating>> getUserRating(@PathVariable Integer userId);
}

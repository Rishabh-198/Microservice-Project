package com.RS.user.service.external.services;

import com.RS.user.service.entities.Rating;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="RatingService")
public interface RatingService {

    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId")
    public void deleteRating(@PathVariable String ratingId);
}

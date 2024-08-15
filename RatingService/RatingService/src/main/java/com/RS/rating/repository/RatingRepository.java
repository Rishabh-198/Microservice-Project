package com.RS.rating.repository;

import com.RS.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    //Custom finder methods

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}

package com.RS.user.service;

import com.RS.user.service.entities.Rating;
import com.RS.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
@Service
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	@Test
	void createRating()
	{

			Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("Created using feign").build();
	Rating savedRating = ratingService.createRating(rating);
	System.out.println("new raitng created");
	}

}

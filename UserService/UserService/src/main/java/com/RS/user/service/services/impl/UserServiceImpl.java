package com.RS.user.service.services.impl;

import com.RS.user.service.entities.Hotel;
import com.RS.user.service.entities.Rating;
import com.RS.user.service.entities.User;
import com.RS.user.service.exceptions.ResourceNotFoundException;
import com.RS.user.service.external.services.HotelService;
import com.RS.user.service.repositories.UserRepository;
import com.RS.user.service.services.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
       String randomUserId= UUID.randomUUID().toString();
       user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
//get user from DB with help of repository
        User user= userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User with given id not found"));
//fetch rating of the above user from rating service

        Rating[] ratingsOfUser=restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}", ratingsOfUser);

        List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList=ratings.stream().map(rating->{
            //api call to hotelservice to get the hotel

        /*    This is done by Rest Template
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel =forEntity.getBody();
            logger.info("response status code: {}"+ forEntity.getStatusCode());

*/

            //This is done by feign client
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            rating.setHotel(hotel);

            return rating;


        }).collect(Collectors.toList());

        user.setRatings(ratingList);
return user;

    }
}

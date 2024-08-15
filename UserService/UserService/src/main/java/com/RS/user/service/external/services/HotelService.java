package com.RS.user.service.external.services;

import com.RS.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HotelService")
public interface HotelService {

    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotel(@PathVariable("hotelId") String hotelId);

}

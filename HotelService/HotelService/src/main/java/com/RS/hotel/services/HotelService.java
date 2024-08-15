package com.RS.hotel.services;

import com.RS.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    List<Hotel> getAll();

    Hotel get(String id);


}

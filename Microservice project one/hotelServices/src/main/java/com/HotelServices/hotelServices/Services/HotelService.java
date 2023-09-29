package com.HotelServices.hotelServices.Services;

import com.HotelServices.hotelServices.Entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(String hotelId);

}

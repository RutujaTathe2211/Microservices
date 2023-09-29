package com.RatingServices.RatingServices.Service;

import com.RatingServices.RatingServices.Entity.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating createRating(Rating rating);
    //getAll ratings
    List<Rating> getAllRatings();

    //get using user id
    List<Rating> getByUserId(String userId);

    //get by using hotelId
    List<Rating> getByHotelId(String hotelId);

}

package com.RatingServices.RatingServices.Controller;

import com.RatingServices.RatingServices.Entity.Rating;
import com.RatingServices.RatingServices.Service.RatingService;
import com.RatingServices.RatingServices.Service.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));

    }
    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }
    //get rating by userId
    @GetMapping("/ratings/users/{userId}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getByUserId(userId));
    }
    @GetMapping("/ratings/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getByHotelId(hotelId));
    }
}

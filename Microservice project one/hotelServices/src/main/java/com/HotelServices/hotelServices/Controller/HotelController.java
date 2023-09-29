package com.HotelServices.hotelServices.Controller;

import com.HotelServices.hotelServices.Entity.Hotel;
import com.HotelServices.hotelServices.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HotelController {
    @Autowired
   private HotelService hotelService;
    //create
    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }
    //get single
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity <Hotel> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
    }
    //get all
    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
    }
}

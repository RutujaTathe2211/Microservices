package microservice.microserviceProject.External.services;

import microservice.microserviceProject.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    //call external api
    @GetMapping("/hotels/{hotelId}")
    //if url path-variable and function parameter are different, then only we need to write hotelId in front of path-variable
    public Hotel getHotel(@PathVariable("hotelId") String hotelId);

}

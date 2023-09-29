package microservice.microserviceProject.External.services;

import microservice.microserviceProject.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    //get
    @GetMapping
    public List<Rating> getAllRating();

    //post
    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating value);

    //put
    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingID, Rating rating);

    //delete
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable("ratingId")String ratingId)   ;
}

package microservice.microserviceProject.Services;

import microservice.microserviceProject.Exception.ResourceSourceNotFoundException;
import microservice.microserviceProject.External.services.HotelService;
import microservice.microserviceProject.Repository.UserRepository;
import microservice.microserviceProject.entity.Hotel;
import microservice.microserviceProject.entity.Rating;
import microservice.microserviceProject.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserImpl.class);

    @Override
    public User saveUser(User user) {
        //generate unique/ random user, id
       String randomUserId= UUID.randomUUID().toString();
       user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        //implement rating service call: using rest template
        return userRepository.findAll();
    }

    //get single user
    @Override
    public User getUser(String userId) {
       //get user from database using user repository
        User user=userRepository.findById(userId).orElseThrow(() -> new ResourceSourceNotFoundException());
        /* fetch rating of the above user from rating services
        http://localhost:8082/users/dabd4c39-afe8-4837-8f6c-13c44285a6fa
        //when we want to fetch rating from rating to user then rating service url is required
         */

        //hardcoded url : http://localhost:8082/users/dabd4c39-afe8-4837-8f6c-13c44285a6fa
        //API CALLING--restTemplate

       Rating[] ratingOfUser= restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
       List<Rating> ratings= Arrays.stream(ratingOfUser).collect(Collectors.toList());
       logger.info("{} ",ratingOfUser);
       //for each rating map with hotel
       List<Rating> ratingList=ratings.stream().map(rating->{
           //api call to hotel service to get the hotel
           //ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);


           //using feign client
           Hotel hotel=hotelService.getHotel(rating.getHotelId());

           //using rest template
//            Hotel hotel=forEntity.getBody();
            //logger.info("Response status code: {}",forEntity.getStatusCode());


           //set the hotel to rating
           rating.setHotel(hotel);

           //return the rating
           return  rating;

       }).collect(Collectors.toList());

       user.setRating(ratingList);

        return user;
    }

}

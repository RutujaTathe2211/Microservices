package microservice.microserviceProject;

import microservice.microserviceProject.External.services.RatingService;
import microservice.microserviceProject.entity.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class MicroserviceProjectApplicationTests {
	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}
//@Test
//	void createRating(){
//		Rating rating=Rating.builder().rating(10).
//				userId("5023243b-d583-4a9b-a289-92385b5e4e6e")
//				.hotelId("616ceea7-a180-4e9f-b088-8146c1525cd4").
//				feedback("This is created using feign client")
//				.build();
//		ResponseEntity<Rating> saveRating=ratingService.createRating(rating);
//		System.out.println("New Rating Created");
//
//	}

}

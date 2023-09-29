package microservice.microserviceProject.entity;

import lombok.*;

import javax.persistence.Transient;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Rating {
    private String userId;
    private String ratingId;
    private String hotelId;
    private int rating;

    private Hotel hotel;

    @Transient //not save in a database
    private String feedback;



}

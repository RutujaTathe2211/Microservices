package microservice.microserviceProject.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class Hotel {

    private String hotelId;
    private String hotelName;
    private String hotelLocation;
    private  String about;
}

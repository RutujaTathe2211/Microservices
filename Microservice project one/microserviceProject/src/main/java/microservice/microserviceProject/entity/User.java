package microservice.microserviceProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name = "Name",length = 20)
    private String name;
    @Column(name= "EMail")
    private String email;
    @Column(name="About")
    private String about;

    @Transient//not save in a database
    private List<Rating> rating=new ArrayList<>();
}

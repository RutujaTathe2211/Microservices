package Quiz_Service.Quiz_Service.model;

import lombok.Data;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    @ElementCollection
    //when we have integer type
    private List<Integer> questionList;

}

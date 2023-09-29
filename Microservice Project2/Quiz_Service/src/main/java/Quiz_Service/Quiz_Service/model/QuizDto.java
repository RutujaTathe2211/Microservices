package Quiz_Service.Quiz_Service.model;

import lombok.Data;

@Data
public class QuizDto {
    private String categoryName;
    private Integer numberQuestion;
    private String title;
}

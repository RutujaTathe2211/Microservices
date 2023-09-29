package Quiz_Service.Quiz_Service.Repository;

import Quiz_Service.Quiz_Service.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
}

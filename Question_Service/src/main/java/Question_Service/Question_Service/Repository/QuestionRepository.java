package Question_Service.Question_Service.Repository;

import Question_Service.Question_Service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);
@Query(value = "SELECT q.id FROM question q where q.category=:category ORDER BY  RAND() LIMIT :numberQuestion",nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, Integer numberQuestion);
}

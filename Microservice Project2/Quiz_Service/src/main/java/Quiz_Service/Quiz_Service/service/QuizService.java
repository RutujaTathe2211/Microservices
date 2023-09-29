package Quiz_Service.Quiz_Service.service;

import Quiz_Service.Quiz_Service.Repository.QuizRepository;
import Quiz_Service.Quiz_Service.feign.QuizInterface;
import Quiz_Service.Quiz_Service.model.QuestionWrapper;
import Quiz_Service.Quiz_Service.model.Quiz;
import Quiz_Service.Quiz_Service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numberQuestion, String title) {
        List<Integer> questions=quizInterface.getQuestionsForQuiz(category,numberQuestion).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(questions);
        quizRepository.save(quiz);
 //
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        //data present or not :use optional
       Quiz quiz=quizRepository.findById(id).get();
       List<Integer> questionIds=quiz.getQuestionList();
       quizInterface.getQuestionFromId(questionIds);
       ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionFromId(questionIds);
       return  questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
         ResponseEntity<Integer> score=quizInterface.getScore(response);
        return score;
    }
}

package Quiz_Service.Quiz_Service.controller;

import Quiz_Service.Quiz_Service.model.QuestionWrapper;
import Quiz_Service.Quiz_Service.model.QuizDto;
import Quiz_Service.Quiz_Service.model.Response;
import Quiz_Service.Quiz_Service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("/quiz/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizdto){
        return quizService.createQuiz(quizdto.getCategoryName(),quizdto.getNumberQuestion(),quizdto.getTitle());
    }
    @GetMapping("/quiz/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
       return  quizService.getQuizQuestions(id);
    }

    //for calculating score of quiz
@PostMapping("/quiz/submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
        return  quizService.calculateResult(id,response);

}

}

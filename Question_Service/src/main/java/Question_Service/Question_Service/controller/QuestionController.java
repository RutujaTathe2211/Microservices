package Question_Service.Question_Service.controller;
import Question_Service.Question_Service.model.Question;
import Question_Service.Question_Service.model.QuestionWrapper;
import Question_Service.Question_Service.model.Response;
import Question_Service.Question_Service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    //generate
    @GetMapping ("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam Integer numberQuestion){
        return questionService.getQuestionsForQuiz(category,numberQuestion);
    }
    //getquestion(Questionid)
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionId){
        return questionService.getQuestionFromId(questionId);
    }
    //getScore
    @PostMapping("getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}

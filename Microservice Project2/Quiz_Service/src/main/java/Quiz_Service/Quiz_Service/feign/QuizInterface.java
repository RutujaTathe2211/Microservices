package Quiz_Service.Quiz_Service.feign;

import Quiz_Service.Quiz_Service.model.QuestionWrapper;
import Quiz_Service.Quiz_Service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//to connect one service to another
@FeignClient(name = "QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("questions/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numberQuestion);
    //getquestion(Questionid)
    @PostMapping("questions/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionId);
    //getScore
    @PostMapping("questions/getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response> responses);



}

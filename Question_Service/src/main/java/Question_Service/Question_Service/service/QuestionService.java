package Question_Service.Question_Service.service;

import Question_Service.Question_Service.Repository.QuestionRepository;
import Question_Service.Question_Service.model.Question;
import Question_Service.Question_Service.model.QuestionWrapper;
import Question_Service.Question_Service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestion(){
        try {
            //return list of question
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        return new ResponseEntity<>( questionRepository.save(question),HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, Integer numberQuestion) {
        List<Integer> questions=questionRepository.findRandomQuestionByCategory(category, numberQuestion);
        return new ResponseEntity<>(questions,HttpStatus.OK);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionId) {
        List<QuestionWrapper> wrappers=new ArrayList<>();
        List<Question> questions=new ArrayList<>();
        for(Integer id:questionId){
            questions.add(questionRepository.findById(id).get());

        }
        for(Question question:questions){
            QuestionWrapper wrapper1=new QuestionWrapper();
            wrapper1.setId(question.getId());
            wrapper1.setQuestionTitle(question.getQuestionTitle());
            wrapper1.setOption1(question.getOption1());
            wrapper1.setOption2(question.getOption2());
            wrapper1.setOption3(question.getOption3());
            wrapper1.setOption4(question.getOption4());

            wrappers.add(wrapper1);
        }

        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int right=0;
        for(Response response1:responses){
            Question question=questionRepository.findById(response1.getId()).get();
            if(response1.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}

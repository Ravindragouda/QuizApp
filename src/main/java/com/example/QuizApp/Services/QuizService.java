package com.example.QuizApp.Services;

import com.example.QuizApp.entity.Question;
import com.example.QuizApp.entity.QuestionWrapper;
import com.example.QuizApp.entity.Quiz;
import com.example.QuizApp.entity.Response;
import com.example.QuizApp.repository.QuestionRepo;
import com.example.QuizApp.repository.QuizRepo;
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
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionRepo.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("success",HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuestionWrapper>> getQuizquestions(Integer id) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> questionsFromDb=quiz.get().getQuestions();
        List<QuestionWrapper> questionForUsers=new ArrayList<>();
        for(Question q:questionsFromDb)
        {
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUsers.add(qw);
        }

        return new ResponseEntity<>(questionForUsers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}

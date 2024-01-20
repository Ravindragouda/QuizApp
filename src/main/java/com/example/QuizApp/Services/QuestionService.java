package com.example.QuizApp.Services;

import com.example.QuizApp.entity.Question;
import com.example.QuizApp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService {

    @Autowired
    QuestionRepo Qrepo;
    public List<Question> getAllQuestions() {

        return Qrepo.findAll();
    }

    public List<Question> getAllQuestionsByCategory(String category){
        return Qrepo.getAllQuestionsByCategory(category);
    }

    public String AddQuestion(Question question) {
        Qrepo.save(question);
        return "Success";
    }

    public String UpdateQuestion(Question question) {
        Qrepo.save(question);
        return "Updated";
    }




    public String DeleteByCategory(Integer id) {
        Qrepo.deleteById(id);
        return " Question is Deleted";
    }
}

package com.example.QuizApp.Services;

import com.example.QuizApp.entity.Question;
import com.example.QuizApp.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionService {

    @Autowired
    QuestionRepo Qrepo;
    public ResponseEntity<List<Question>> getAllQuestions() {

        try {
            return new ResponseEntity<>(Qrepo.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category){
        try
        {
            return new ResponseEntity<>( Qrepo.getAllQuestionsByCategory(category),HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> AddQuestion(Question question) {
        try {
            Qrepo.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> UpdateQuestion(Question question) {
        try
        {
            Qrepo.save(question);
            return new ResponseEntity<>("Updated",HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> DeleteByCategory(Integer id) {
        try {

                Qrepo.deleteById(id);
                return new ResponseEntity<>(" Question is Deleted",HttpStatus.ACCEPTED);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Failed to Delete the question",HttpStatus.BAD_REQUEST);

    }
}

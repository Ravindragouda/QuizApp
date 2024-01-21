package com.example.QuizApp.Controller;

import com.example.QuizApp.Services.QuestionService;
import com.example.QuizApp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class HomeController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allquestions")
    public ResponseEntity<List <Question> > getAllQuestions(){

       return (ResponseEntity<List<Question>>) questionService.getAllQuestions();

    }

    @GetMapping("category/{category}")
    public ResponseEntity<List <Question>>  getAllQuestionsByCategory(@PathVariable String category){

        return questionService.getAllQuestionsByCategory(category);

    }

    @PostMapping("/add")
    public ResponseEntity<String> AddQuestion(@RequestBody Question question)
    {
        return questionService.AddQuestion(question);
    }
    @PutMapping("/update")

    public ResponseEntity<String> update(@RequestBody Question question)
    {
        return questionService.UpdateQuestion(question);
    }

   @DeleteMapping("/delete/{id}")

       public ResponseEntity<String> DeleteByid(@PathVariable Integer id)
       {
           return questionService.DeleteByCategory(id);
       }



}

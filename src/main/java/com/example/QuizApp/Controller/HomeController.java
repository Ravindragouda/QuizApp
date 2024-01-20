package com.example.QuizApp.Controller;

import com.example.QuizApp.Services.QuestionService;
import com.example.QuizApp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class HomeController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allquestions")
    public List <Question>  getAllQuestions(){

       return questionService.getAllQuestions();

    }

    @GetMapping("categeory/{category}")
    public List <Question>  getAllQuestionsByCategory(@PathVariable String category){

        return questionService.getAllQuestionsByCategory(category);

    }

    @PostMapping("/add")
    public String AddQuestion(@RequestBody Question question)
    {
        return questionService.AddQuestion(question);
    }
    @PutMapping("/update")

    public String update(@RequestBody Question question)
    {
        return questionService.UpdateQuestion(question);
    }

   @DeleteMapping("/delete/{id}")

       public String DeleteByid(@PathVariable Integer id)
       {
           return questionService.DeleteByCategory(id);
       }



}

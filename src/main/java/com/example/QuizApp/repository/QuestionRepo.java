package com.example.QuizApp.repository;

import com.example.QuizApp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer>
{

    List<Question> getAllQuestionsByCategory(String category);



}

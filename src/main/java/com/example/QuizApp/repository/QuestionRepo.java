package com.example.QuizApp.repository;

import com.example.QuizApp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer>
{

    List<Question> getAllQuestionsByCategory(String category);


    @Query(value = "SELECT * FROM question q WHERE q.category = ? ORDER BY RANDOM() LIMIT ?", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}

package com.ipad.project.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	Question findByTitle(String Title);
    Question findByTitleAndContent(String Title, String content);
    List<Question> findByTitleLike(String subject);
    Page<Question> findAll(Pageable pageable);

	
}
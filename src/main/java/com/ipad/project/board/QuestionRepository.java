package com.ipad.project.board;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;



public interface QuestionRepository extends JpaRepository<Question, Integer>{

	
}
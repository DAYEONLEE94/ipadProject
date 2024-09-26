package com.ipad.project;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipad.project.board.Question;
import com.ipad.project.board.QuestionRepository;
import com.ipad.project.board.QuestionService;

@SpringBootTest
class IpadProjectApplicationTests {

	@Autowired
	private QuestionService questionService;


	  @Test
	    void testJpa() {
	        for (int i = 1; i <= 300; i++) {
	            String title = String.format("테스트 데이터입니다:[%03d]", i);
	            String content = "내용무";
	            this.questionService.write(title, content);
	        }
	    }

}

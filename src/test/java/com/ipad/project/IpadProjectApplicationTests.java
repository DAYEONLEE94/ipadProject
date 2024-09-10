package com.ipad.project;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipad.project.board.Question;
import com.ipad.project.board.QuestionRepository;

@SpringBootTest
class IpadProjectApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	/*
	 * @Test void JpaTest() { Question q1 = new Question(); q1.setTitle("제목");
	 * q1.setContent("제목이 잘 들어갔나요?"); q1.setCreateDate(LocalDateTime.now());
	 * this.questionRepository.save(q1); }
	 */

	@Test
	void JpaTest() {
		Question q2 = new Question();
		q2.setTitle("테스트");
		q2.setContent("테스트도 잘 들어가나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}

}

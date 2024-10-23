package com.ipad.project.board;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.ipad.project.member.UserDb;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
	
	private final AnswerRepository answerRepository;

	public void create(Question question, String content, UserDb author) {
		Answer answer = new Answer();
		
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setAuthor(author);
		this.answerRepository.save(answer);
	}

}

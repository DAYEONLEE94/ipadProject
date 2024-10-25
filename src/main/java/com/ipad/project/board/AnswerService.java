package com.ipad.project.board;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import com.ipad.project.DataNotFoundException;
import com.ipad.project.member.UserDb;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {
	
	private final AnswerRepository answerRepository;

	public Answer create(Question question, String content, UserDb author) {
		Answer answer = new Answer();
		
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setAuthor(author);
		this.answerRepository.save(answer);
		return answer;
	}
	
	public Answer getAnswer(Integer id) {
		Optional<Answer> answer = this.answerRepository.findById(id);
		if(answer.isPresent()) {
			return answer.get();
		}else {
			throw new DataNotFoundException("answer not found");
		}
	}
	
	public void modify(Answer answer, String content) {
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(answer);
	}

	public void delete(Answer answer) {
		this.answerRepository.delete(answer);
	}
	
	public void vote(Answer answer, UserDb userDb) {
		answer.getVoter().add(userDb);
		this.answerRepository.save(answer);
	}
}

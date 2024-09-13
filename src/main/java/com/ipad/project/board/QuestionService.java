package com.ipad.project.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ipad.project.DataNotFoundException;

import lombok.RequiredArgsConstructor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;

	public List<Question> getList() {
		return this.questionRepository.findAll();
	}

	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		} else {
			throw new DataNotFoundException("question not found");
		}

	}
	
	public void write(String title, String content) {
		Question addWrite = new Question();
		addWrite.setTitle(title);
		addWrite.setContent(content);
		addWrite.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(addWrite);
		
	}

}

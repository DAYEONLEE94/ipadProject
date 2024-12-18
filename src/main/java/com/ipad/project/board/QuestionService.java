package com.ipad.project.board;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ipad.project.DataNotFoundException;
import com.ipad.project.member.UserDb;

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
	
	public void write(String title, String content, UserDb member) {
		Question addWrite = new Question();
		addWrite.setTitle(title);
		addWrite.setContent(content);
		addWrite.setCreateDate(LocalDateTime.now());
		addWrite.setAuthor(member);
		this.questionRepository.save(addWrite);
	}
	
	public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }
	
	public void modify(Question question, String title, String content) {
		question.setTitle(title);
		question.setContent(content);
		question.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}
	
	public void delete(Question question) {
		this.questionRepository.delete(question);
	}
	
	public void vote(Question question, UserDb userDb) {
		question.getVoter().add(userDb);
		this.questionRepository.save(question);
	}
}

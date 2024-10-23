package com.ipad.project.board;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipad.project.member.UserDb;
import com.ipad.project.member.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
	
	 private final QuestionService questionService;
	 private final AnswerService answerService;
	 private final UserService userService;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id, @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
		Question question = this.questionService.getQuestion(id);
		
		UserDb userDb = this.userService.getUser(principal.getName());
		if(bindingResult.hasErrors()) {
			model.addAttribute("question", question);
			return "board_detail";
		}
		
		this.answerService.create(question, answerForm.getContent(), userDb);
		return String.format("redirect:/question/detail/%s", id);
	}
	
	
	
	

}

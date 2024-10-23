package com.ipad.project.board;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.ipad.project.member.UserDb;
import com.ipad.project.member.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
	
	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	private final UserService userService;
	

	@GetMapping("/list")
	public String list(Model model,  @RequestParam(value="page", defaultValue="0") int page) {
		Page<Question> paging = this.questionService.getList(page);
		model.addAttribute("paging", paging);
		System.out.println("커뮤니티 입장");
//		System.out.println("찍히고 있나요? " + questionList.get(0).getTitle());
//		System.out.println("찍히고 있나요? " + questionList.get(0).getContent());
		return "board_List";
	}
	
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);		
		System.out.println("board_detail start");
		return "board_detail";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/write")
	public String write(QuestionForm questionForm) {
		System.out.println("write start");
		return "board_Form";
	} 
	
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/write")
	public String questionWrite(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
		if(bindingResult.hasErrors()) {
			return "board_Form";
		}
		UserDb userDb = this.userService.getUser(principal.getName());
		this.questionService.write(questionForm.getTitle(), questionForm.getContent(), userDb);
		return "redirect:/question/list";
		
	}
	

}

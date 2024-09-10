package com.ipad.project.board;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {
	
	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	

	@GetMapping("/list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		System.out.println("커뮤니티 입장");
//		System.out.println("찍히고 있나요? " + questionList.get(0).getTitle());
//		System.out.println("찍히고 있나요? " + questionList.get(0).getContent());
		return "board_List";
	}
	
	@GetMapping("/write")
	public String write() {
		System.out.println("write start");
		return "board_Form";
	}
	
	@GetMapping(value = "/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);		
		System.out.println("board_detail start");
		return "board_detail";
	}
	

}

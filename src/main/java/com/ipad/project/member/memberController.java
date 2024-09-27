package com.ipad.project.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/member")
public class memberController {
	
	@GetMapping("/join")
	public String joinForm() {
				
		return "member_joinForm";
	}
	

}

package com.ipad.project.member;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/join")
	public String joinForm(UserForm userForm) {

		return "member_joinForm";
	}

	@PostMapping("/join")
	public String joinForm(@Valid UserForm userForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "member_joinForm";
		}
		if (!userForm.getPassword1().equals(userForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");
			return "member_joinForm";
		}
		try {
			userService.create(userForm.getUserId(), userForm.getPassword1(), userForm.getUsername(), userForm.getPhone(), userForm.getEmail());

		}catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
			return "member_joinForm";
		}catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", e.getMessage());
			return "member_joinForm";
		}
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member_loginForm";
	}
	

	
	

}

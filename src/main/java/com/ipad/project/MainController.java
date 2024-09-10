package com.ipad.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value = "/")
	public String mainRecommand() {
		System.out.println("main redirect");
		return "redirect:/main" ;
	}
	
	@GetMapping(value = "/main")
	public String mainCommand() {
		System.out.println("main start");
		return "main";
	}
}
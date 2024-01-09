package com.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/about")
	public String about(Model model) {
		System.out.println("Inside About Handler");
		
		model.addAttribute("name", "Sneha");
		
		return "about"; // show about.html
	}
	
}

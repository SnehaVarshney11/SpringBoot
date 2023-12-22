package com.springboot.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String Home() {
		System.out.println("This is Home Page");
		return "home";
	}
	
	@RequestMapping("/contact")
	public String Contact() {
		System.out.println("This is contact page");
		return "contact";
	}
}

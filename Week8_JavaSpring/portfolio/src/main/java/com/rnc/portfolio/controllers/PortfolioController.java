package com.rnc.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioController {
	@RequestMapping("/")
	public String home() {
		return "forward:/home.html";
	}
	
	@RequestMapping("/me")
	public String me() {
		return "forward:/aboutme.html";
	}
	
	@RequestMapping("/projects")
	public String projects() {
		System.out.println("I'm here!");
		return "forward:/myprojects.html";
	}
	
}

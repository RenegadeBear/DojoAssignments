package com.rnc.learniningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LearningPlatform {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/lesson/{name}")
	public String lesson(@PathVariable("name") String lesson_name) {
		return "lesson.jsp";
	}
	
	@RequestMapping("/assignment/{name}")
	public String assignment(@PathVariable("name") String assignment_name) {
		return "assignment.jsp";
	}
	
	@RequestMapping("/quiz/{name}")
	public String quiz(@PathVariable("name") String quiz_name) {
		return "quiz.jsp";
	}
}

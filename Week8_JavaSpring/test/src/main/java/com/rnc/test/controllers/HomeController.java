package com.rnc.test.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	Date datetime = new Date();
	
	@RequestMapping ("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping ("displaydate")
	public String date(Model model) {
		String today = String.format("%s %tA, the %<te of %<tB, %<tY", "Date:", datetime);
		model.addAttribute("date", today);
		System.out.println(today);
		return "date.jsp";
	}
	
	@RequestMapping ("displaytime")
	public String time(Model model) {
		String time = String.format("%s %tI:%<tM %<tp", "Time:", datetime);
		model.addAttribute("time", time);
		return "time.jsp";
	}
}

package com.hygogg.dojosurvey.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Surveys {
	
	public ArrayList<String> names = new ArrayList<String>();

	@RequestMapping("")
	public String index(Model model, HttpSession session) {
		if(names.size() == 0) {			
			names.add("Zoya");
			names.add("Rocky");
			names.add("Marisa");
			names.add("Walter");
		}
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			count = 0;
		}
		count++;
//		model.addAttribute("count", 1);
		session.setAttribute("count", count);
		model.addAttribute("nombres", names);
		return "index";
	}
	
	@RequestMapping("another")
	public String another() {
		return "another";
	}
	
}

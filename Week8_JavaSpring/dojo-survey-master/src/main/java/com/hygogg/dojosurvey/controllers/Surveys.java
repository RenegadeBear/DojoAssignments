package com.hygogg.dojosurvey.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		session.setAttribute("count", count);
		model.addAttribute("nombres", names);
		return "index";
	}
	
	@PostMapping("process")
	public String process(@RequestParam Map<String, String> body, HttpSession session, 
			RedirectAttributes flash) {
		System.out.println(body);
		if (body.get("name").length() < 1) {
			flash.addFlashAttribute("nameerror", "You are despicable for not having a name");
			return "redirect:/";
		} else if (body.get("name").equals("Sam")) {
			flash.addFlashAttribute("nameerror", "Sam's are not allowed!!!!!!!!");
			return "redirect:/";
		}
		session.setAttribute("body", body);
		return "redirect:/another";
	}
	
	@RequestMapping("another")
	public String another() {
		return "another";
	}
	
}

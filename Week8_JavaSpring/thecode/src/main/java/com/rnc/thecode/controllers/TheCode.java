package com.rnc.thecode.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCode {
	@RequestMapping("")
	public String index(@ModelAttribute("errors") String errors) {
		System.out.println(errors);
		return "index.jsp";
	}
	
	@RequestMapping(path="/trycode", method=RequestMethod.POST)
	public String trycode(@RequestParam Map<String, String> body, HttpSession session, RedirectAttributes flash) {
		System.out.println(body.get("code"));
		String code = (String)body.get("code");
		if (code.equals("bushido")) {
			return "code.jsp";
		}
		flash.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
		
	}
	

}

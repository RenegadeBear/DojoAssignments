package com.rnc.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rnc.dojoninjas.models.Dojo;
import com.rnc.dojoninjas.services.DojoService;

@Controller
public class Dojos {
	
	@Autowired
	private DojoService dojoService;

	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("dojos/new")
	public String dojonew(@ModelAttribute("newdojo") Dojo dojo) {
		return "dojo";
	}
	
	@PostMapping("adddojo")
	public String adddojo(@Valid @ModelAttribute("newdojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojo";
		}
		dojoService.create(dojo);
		return "redirect:/";
	}
	
}

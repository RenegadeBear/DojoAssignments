package com.rnc.dojolicense.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rnc.dojolicense.models.Person;
import com.rnc.dojolicense.services.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("person/new")
	public String newperson(@ModelAttribute("new") Person person) {
		return "newperson";
	}
	
	@PostMapping("addperson")
	public String addperson(@Valid @ModelAttribute("new") Person person, BindingResult result) { 
		if (result.hasErrors()) {
			return "newperson";
		}
		System.out.println(person.getFirst());
		personService.create(person);
		return "redirect:/";
	}
	
	
}

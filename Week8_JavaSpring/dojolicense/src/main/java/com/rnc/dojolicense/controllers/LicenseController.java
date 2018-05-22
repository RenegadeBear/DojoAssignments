package com.rnc.dojolicense.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rnc.dojolicense.models.License;
import com.rnc.dojolicense.models.Person;
import com.rnc.dojolicense.services.LicenseService;
import com.rnc.dojolicense.services.PersonService;

@Controller
public class LicenseController {
	
	@Autowired
	private LicenseService licenseService;
	@Autowired
	private PersonService personService;
	
	
	@RequestMapping("license/new")
	public String newlicense(@ModelAttribute("generate") License license, Model model) {
		model.addAttribute("people", personService.all());
		return "newlicense";
	}
	
	@PostMapping("newlicense")
	public String generateLicense(@Valid @ModelAttribute("generate") License license, BindingResult result) {
		
		if (result.hasErrors()) {
			return "newlicense";
		}
		System.out.println("expiration date: ");
		System.out.println(license.getExpiration());
		licenseService.create(license);
		return "redirect:/";
	}
	
	@RequestMapping("show/{id}")
	public String show(Model model, @PathVariable(value="id") Long id) {
		System.out.println("arrived at show path");
		model.addAttribute("license", licenseService.findById(id));
		System.out.println(licenseService.findById(id));
		Person whom = licenseService.findById(id).getPerson();
		System.out.println(whom.getId());
		model.addAttribute("person", personService.findById(whom.getId()));
		return "show";
	}
	
	
}

package com.rnc.lang.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rnc.lang.models.Language;
import com.rnc.lang.services.LanguageService;

@Controller
public class Languages {

	private LanguageService languageService;
	
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("language", new Language());
		model.addAttribute("languages", languageService.all());
		return "index";
	}
	
	@PostMapping("/addlang")
	public String languages(@Valid @ModelAttribute("language") Language language, BindingResult result) {
//		 RedirectAttributes flash
		System.out.println(language.getName());
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
//			flash.addFlashAttribute(language)
			return "index";
		}
		
		languageService.create(language);
		return "redirect:/";
	}

	@RequestMapping("/show/{id}")
	public String findLanguageById(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguageById(id);
		model.addAttribute("language", language);
		return "show";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String destoryLanguage(@PathVariable("id") Long id) {
		languageService.destroyLanguage(id);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") Long id) {
		Language language = languageService.findLanguageById(id);
		model.addAttribute("language", language);

		return "edit";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "edit";
		}
		else {
			languageService.updateLanguage(language);
			return "redirect:/";
		}

		
	}
}

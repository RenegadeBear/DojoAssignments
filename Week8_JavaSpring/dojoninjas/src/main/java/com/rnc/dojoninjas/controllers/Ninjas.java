package com.rnc.dojoninjas.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rnc.dojoninjas.models.Dojo;
import com.rnc.dojoninjas.models.Ninja;
import com.rnc.dojoninjas.services.DojoService;
import com.rnc.dojoninjas.services.NinjaService;

@Controller
public class Ninjas {
	
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;

	@RequestMapping("ninja/new")
	public String ninjanew(@ModelAttribute("newninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.all());
		return "ninja";
	}
	
	@PostMapping("addninja")
	public String addninja(@ModelAttribute("newninja") Ninja ninja, Model model, BindingResult result, @RequestParam(value="DATEOFBIRTH") String dob) {

		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.all());
			return "ninja";
		}
		System.out.println(dob);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale(Locale.US);
		LocalDate dt = LocalDate.parse(dob,formatter);
		ninja.setDob(dt);
		System.out.println(ninja.getDob() + "****" + LocalDate.now());
		ninjaService.create(ninja);
		
		return "redirect:/";
	}
	
	@RequestMapping("show/{id}")
	public String show(Model model, @PathVariable(value="id") Long id) {
		System.out.println("arrived at show path");
		model.addAttribute("dojo", dojoService.findById(id));
		System.out.println(dojoService.findById(id));
		List<Ninja> ninjas = dojoService.findById(id).getNinjas();
		model.addAttribute("ninjas", ninjas);
		return "show";
	}
	
	
	
}

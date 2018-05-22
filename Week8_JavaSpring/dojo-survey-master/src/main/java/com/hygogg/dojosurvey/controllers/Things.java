package com.hygogg.dojosurvey.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Things {
	
	@RequestMapping("thing/{alsothing}")
	public String thing(@PathVariable String alsothing) {
		return String.format("You are looking for %s", alsothing);
	}
	
}

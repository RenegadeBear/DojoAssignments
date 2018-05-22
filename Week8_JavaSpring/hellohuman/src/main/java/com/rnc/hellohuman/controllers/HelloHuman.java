package com.rnc.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {

//	@RequestMapping("/")
//	public String index() {
//		return "Hello Human!";
//	}
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", defaultValue="Human") String name, 
				@RequestParam(value="last", defaultValue="Being") String last) {

		return "Hello " +name +" "+last;
		
		//http://localhost:8080/?name=Racheal&last=Crowder
	}
}

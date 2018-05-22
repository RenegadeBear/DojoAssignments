package com.rnc.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	
	public String hello() {
		return "Hello World!";
	}
	
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("dojoName", "Burbank");
        return "index.jsp";
    }
	
}

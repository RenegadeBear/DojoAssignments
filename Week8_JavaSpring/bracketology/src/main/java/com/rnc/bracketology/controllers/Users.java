package com.rnc.bracketology.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rnc.bracketology.models.User;
import com.rnc.bracketology.services.UserService;
import com.rnc.bracketology.validator.UserValidator;

@Controller
public class Users {

	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	ObjectMapper mapper = new ObjectMapper();
	
	public Users(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	  
    @PostMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user,  BindingResult result, Model model, HttpSession session) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
    		return "index";
    	}
    	ArrayList<User> existing = userService.all();
    	System.out.println(existing);
    	System.out.println(existing.size());
    		if (existing.size() == 0) {
    			userService.saveWithUserRole(user);
    			userService.addAdminRole(user);
    			
    		}
    		else {
    			userService.saveWithUserRole(user);
    		}
        return "redirect:/";
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "adminPage";
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
    	if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        model.addAttribute("user", new User());
        return "index";
    }
	
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();

        model.addAttribute("currentUser", userService.findByUsername(username));
        Date sign_in = userService.findByUsername(username).getLast_sign_in();
        System.out.println("previous last_sign_in: "+sign_in);

        userService.findByUsername(username).setLast_sign_in(new Date());
        System.out.println("previous last_sign_in: "+ userService.findByUsername(username).getLast_sign_in());
        
        return "homePage";
    }
    
	@PostMapping("/fifaData")
	public String getData(@RequestParam("myData") String mydata) throws JsonParseException, JsonMappingException, IOException {
//		Map<String, String> team = mydata;
		System.out.println(mydata);
		Map<String,Object> map = mapper.readValue(mydata, Map.class);
		System.out.println(map.get("id"));
		return "redirect:/";
	}
	
	@RequestMapping("makebracket")
	public String bracketmaker(Principal principal, Model model) {
        String username = principal.getName();

        model.addAttribute("currentUser", userService.findByUsername(username));
        
        return "yourBracket";
	}
	
}

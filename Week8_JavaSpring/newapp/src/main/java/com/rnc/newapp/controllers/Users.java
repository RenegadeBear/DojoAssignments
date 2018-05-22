package com.rnc.newapp.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rnc.newapp.models.User;
import com.rnc.newapp.services.UserService;
import com.rnc.newapp.validator.UserValidator;

@Controller
public class Users {

	private UserService userService;
	
	private UserValidator userValidator;
	
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
	
}

package com.rnc.events.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rnc.events.models.Event;
import com.rnc.events.models.State;
import com.rnc.events.models.User;
import com.rnc.events.services.EventService;
import com.rnc.events.services.StateService;
import com.rnc.events.services.UserService;
import com.rnc.events.validator.UserValidator;

@Controller
public class Users {

	private UserService userService;
	private StateService stateService;
	private EventService eventService;
	
	private UserValidator userValidator;
	
	public Users(UserService userService, UserValidator userValidator, StateService stateService, EventService eventService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.stateService = stateService;
		this.eventService = eventService;
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
        model.addAttribute("states", stateService.all());
        return "index";
    }
	
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model, HttpSession session) {
            	
    	// 1
        String username = principal.getName();

        model.addAttribute("currentUser", userService.findByUsername(username));
        session.setAttribute("currentUser", userService.findByUsername(username));
        Date sign_in = userService.findByUsername(username).getLast_sign_in();
        userService.findByUsername(username).setLast_sign_in(new Date());
//        System.out.println("previous last_sign_in: "+ userService.findByUsername(username).getLast_sign_in());
        
        model.addAttribute("states", stateService.all());
        model.addAttribute("newevent", new Event());
        State userState = userService.findByUsername(username).getState();
        System.out.println(eventService.findAllByState(userState).get(0).getUsers());
        model.addAttribute("localevents", eventService.findAllByState(userState));
        model.addAttribute("distantevents", eventService.findDistant(userState));
        return "homePage";
    }
	
}

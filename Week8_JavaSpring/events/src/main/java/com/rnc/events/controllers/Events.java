package com.rnc.events.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rnc.events.models.Comment;
import com.rnc.events.models.Event;
import com.rnc.events.models.State;
import com.rnc.events.models.User;
import com.rnc.events.services.CommentService;
import com.rnc.events.services.EventService;
import com.rnc.events.services.StateService;
import com.rnc.events.services.UserService;


@Controller
public class Events {

	private EventService eventService;
	private UserService userService;
	private StateService stateService;
	private CommentService commentService;
	
	public Events(EventService eventService, UserService userService, StateService stateService, CommentService commentService) {
		this.eventService = eventService;
		this.userService = userService;
		this.stateService = stateService;
		this.commentService = commentService;
	}
	
	@PostMapping("event")
	public String newEvent(@Valid @ModelAttribute("newevent") Event event, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			return "homePage";
		}
		eventService.create(event);
		return "redirect:/";
	}
	
	@RequestMapping("{id}/{username}/join")
	public String joinEvent(@PathVariable("id")Long id, @PathVariable("username")String username, HttpSession session) {
		System.out.println("event:"+id+" username:"+username);
		Event thisevent = eventService.findById(id);
		User thisuser = userService.findByUsername(username);
		eventService.joinUserEvent(thisevent, thisuser);
		return "redirect:/";
	}

	@RequestMapping("{id}/{username}/cancel")
	public String cancelEvent(@PathVariable("id")Long id, @PathVariable("username")String username, HttpSession session) {
		Long thisevent = id;
		Long thisuser = userService.findByUsername(username).getId();
		System.out.println("event id: "+id+" userid: "+ thisuser);
		eventService.cancelUserEvent(thisevent, thisuser);
		return "redirect:/";
	}
	
	@RequestMapping("event/{id}")
	public String viewEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Event e = eventService.findById(id);
		model.addAttribute("event", e);
		model.addAttribute("comment", new Comment());
		model.addAttribute("usercomments", eventService.findById(id).getComments());
		return "view";
	}
	
	@PostMapping("comment")
	public String addComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result, Model model) {
		System.out.print(comment.getText());
		System.out.print(comment.getUser());
		System.out.print(comment.getEvent());
		if (result.hasErrors() ) {
			return "view";
		}
		commentService.create(comment);
		return "redirect:/event/"+comment.getEvent().getId();
	}
	
	
}

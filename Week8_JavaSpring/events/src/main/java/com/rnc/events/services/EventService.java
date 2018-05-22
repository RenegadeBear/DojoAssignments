package com.rnc.events.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rnc.events.models.Event;
import com.rnc.events.models.State;
import com.rnc.events.models.User;
import com.rnc.events.repositories.EventRepo;

@Service
public class EventService {
	private EventRepo eventRepo;
	private UserService userService;
	
	public EventService(EventRepo eventRepo, UserService userService) {
		this.eventRepo = eventRepo;
		this.userService = userService;
	}
	
	public Event create(Event event) {
		return eventRepo.save(event);
	}
	
	public ArrayList<Event> all() {
		return (ArrayList<Event>) eventRepo.findAll();
	}
	
	public Event findById(Long id) {
		return eventRepo.findOne(id);
	}
	
	public ArrayList<Event> findAllByState(State state) {
		return (ArrayList<Event>) eventRepo.findAllByState(state);
	}
	
	public ArrayList<Event> findDistant(State state) {
		return (ArrayList<Event>) eventRepo.findDistant(state);
	}
	
	public void joinUserEvent(Event event, User user) {
		List<User> thiseventsusers = event.getUsers();
		thiseventsusers.add(user);
		event.setUsers(thiseventsusers);
	    eventRepo.save(event);
	}
	
	public void cancelUserEvent(Long event, Long user) {
		Event thisevent = this.findById(event);
		List<User> users = thisevent.getUsers();
		Event e = eventRepo.findOne(event);
		User u = userService.findById(user);
		e.getUsers().remove(u);
		eventRepo.save(e);	
	}
	    
}

package com.rnc.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min=3, message="Name must be 3 or more characters")
    private String name;
    @NotNull(message="Date is required")
    @Future(message="Unable to create events in past, please use future date")
    @DateTimeFormat(iso = ISO.DATE)
    private Date eventDate;
    @Size(min=2, message="Location must be 2 or more characters")
    private String location;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="state_id")
    private State state;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private User host;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "events_users", 
            joinColumns = @JoinColumn(name = "event_id"), 
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	private List<Comment> comments;
    
    
    public Event() {
    }
    
    public Event(String name, Date eventDate, String location, State state, User host) {
    	this.name = name;
    	this.eventDate = eventDate;
    	this.location = location;
    	this.state = state;
    	this.host = host;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}

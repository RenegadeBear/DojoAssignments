package com.rnc.javaskillsdemo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reviews")
public class Review {
	@Id
    @GeneratedValue
    private Long id;
	@NotNull
    @Min(1)
    @Max(5)
    private Integer rating;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tvshow_id")
	private TVShow tvshow;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public Review() {
    }
    
    public Review(int rating, User user, TVShow tvshow) {
    	this.rating = rating;
    	this.user = user;
    	this.tvshow = tvshow;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TVShow getTvshow() {
		return tvshow;
	}

	public void setTvshow(TVShow tvshow) {
		this.tvshow = tvshow;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}

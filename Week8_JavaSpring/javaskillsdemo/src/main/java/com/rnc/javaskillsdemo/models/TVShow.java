package com.rnc.javaskillsdemo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tvshows")
public class TVShow {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Size(min=3)
    private String name;
    @NotNull
    @Size(min=2)
    private String network;
    private Double avg_rating;
    @NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User submitter;
    @OneToMany(mappedBy="tvshow", fetch = FetchType.LAZY)
    private List<Review> reviews;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
        
    public TVShow() {
    }
    
    public TVShow(String name, String network, User submitter) {
    	this.name = name;
    	this.network = network;
    	this.submitter = submitter;
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

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public Double getAvg_rating() {
		return avg_rating;
	}

	public void setAvg_rating(Double avg_rating) {
		this.avg_rating = avg_rating;
	}

	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
		this.submitter = submitter;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
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

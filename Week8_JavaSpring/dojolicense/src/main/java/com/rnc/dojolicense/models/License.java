package com.rnc.dojolicense.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="licenses")
public class License {

	@Id
	@GeneratedValue
	private Long id;
	private String number;
	private LocalDate expiration;
	private String state;
	private Date created_at;
	private Date updated_at;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    @Transient
    private static int count;
    
    public License() {
    	this.count += 1;
    	this.number = String.format("%06d", this.count);
    	this.expiration = LocalDate.now().plusDays(1095);
    }
    
    public License(String state, Person person) {
    	this.state = state;
    	this.person = person;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getExpiration() {
		return expiration;
	}

	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
    
	@PrePersist
    protected void onCreate(){
		this.setCreated_at(new Date());
		this.setUpdated_at(new Date());
    }

    @PreUpdate
    protected void onUpdate(){
    	this.setUpdated_at(new Date());
    }
	
}
    
    

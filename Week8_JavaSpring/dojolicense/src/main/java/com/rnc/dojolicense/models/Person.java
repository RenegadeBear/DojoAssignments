package com.rnc.dojolicense.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="First name is required")
	@Size(min=2, message="First name must be 2 or more characters")
	private String first;
	@NotNull(message="Last name is required")
	@Size(min=2, message="Last name must be 2 or more characters")
	private String last;
	@Column(updatable=false)
	private Date created_at;
	private Date updated_at;
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License license;
	
	public Person() {
	}
	
	public Person(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
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
	
	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
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

package com.rnc.dojoninjas.models;

import java.time.LocalDate;
import java.time.Period;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message="First name is required")
	@Size(min=2, message="First name must be 2 or more characters")
	private String first_name;
	@NotNull(message="Last name is required")
	@Size(min=2, message="Last name must be 2 or more characters")
	private String last_name;
	@DateTimeFormat(pattern="MM:dd:yyyy")
	private LocalDate dob;
	private int age;
	@Column(updatable=false)
	private Date created_at;
	private Date updated_at;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
	
	public Ninja() {
	}
	
	public Ninja(String first_name, String last_name, LocalDate dob) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
	}
	
	@PrePersist
    protected void onCreate(){
		this.setCreated_at(new Date());
		this.setUpdated_at(new Date());
		Period days = Period.between(dob, LocalDate.now());
		int age = days.getYears();
		System.out.println(age);
		this.setAge(age);
		
    }

    @PreUpdate
    protected void onUpdate(){
    	this.setUpdated_at(new Date());

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
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

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
    
	

}

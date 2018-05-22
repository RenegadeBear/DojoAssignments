package com.rnc.dojolicense.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.rnc.dojolicense.models.Person;
import com.rnc.dojolicense.repositories.PersonRepo;

@Service
public class PersonService {
	
	private PersonRepo personRepo;
	
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	public void create(Person person) {
		System.out.println("message for you");
		personRepo.save(person);
	}
	
	public ArrayList<Person> all() {
		return (ArrayList<Person>) personRepo.findAll();
	}

	public Person findById( Long id) {
		return personRepo.findOne(id);
	}
	
}

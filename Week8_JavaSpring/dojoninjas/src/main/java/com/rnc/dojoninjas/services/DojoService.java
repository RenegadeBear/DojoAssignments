package com.rnc.dojoninjas.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.rnc.dojoninjas.models.Dojo;
import com.rnc.dojoninjas.repositories.DojoRepo;

@Service
public class DojoService {
	
	private DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public ArrayList<Dojo> all() { 
		return (ArrayList<Dojo>) dojoRepo.findAll();
	}
	
	public Dojo findById(Long id) {
		return dojoRepo.findOne(id);
	}

}

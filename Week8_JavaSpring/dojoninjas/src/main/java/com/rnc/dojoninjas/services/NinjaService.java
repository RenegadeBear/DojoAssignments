package com.rnc.dojoninjas.services;

import org.springframework.stereotype.Service;

import com.rnc.dojoninjas.models.Ninja;
import com.rnc.dojoninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	private NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	
	
}

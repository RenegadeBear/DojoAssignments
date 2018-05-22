package com.rnc.events.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.rnc.events.models.State;
import com.rnc.events.repositories.StateRepo;

@Service
public class StateService {
	private StateRepo stateRepo;
	

	public StateService(StateRepo stateRepo) {
		this.stateRepo = stateRepo;
	}

	public ArrayList<State> all(){
		return (ArrayList<State>) stateRepo.findAll();
	}
	
}

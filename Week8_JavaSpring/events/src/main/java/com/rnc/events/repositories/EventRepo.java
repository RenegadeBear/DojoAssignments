package com.rnc.events.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.events.models.Event;
import com.rnc.events.models.State;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {

	public ArrayList<Event> findAllByState(State state);
	
		
	@Query(value="SELECT * FROM events WHERE state_id NOT LIKE ?1", nativeQuery=true)
	public ArrayList<Event> findDistant(State state);
	
	
}

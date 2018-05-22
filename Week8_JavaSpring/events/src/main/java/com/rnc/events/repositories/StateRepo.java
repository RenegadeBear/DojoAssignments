package com.rnc.events.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rnc.events.models.State;

public interface StateRepo extends CrudRepository<State, Long> {

}

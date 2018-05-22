package com.rnc.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.events.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
}

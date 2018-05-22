package com.rnc.bracketology.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.bracketology.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
}

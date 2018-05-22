package com.rnc.javaskillsdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.javaskillsdemo.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
}

package com.rnc.firstsafeapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.firstsafeapp.models.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {

	List<Role> findAll();
	
	List<Role> findByName(String string);

}

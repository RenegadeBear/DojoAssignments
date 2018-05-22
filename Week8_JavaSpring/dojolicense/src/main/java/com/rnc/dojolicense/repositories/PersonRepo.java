package com.rnc.dojolicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.dojolicense.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {

}

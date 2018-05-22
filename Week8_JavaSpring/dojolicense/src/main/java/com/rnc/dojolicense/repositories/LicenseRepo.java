package com.rnc.dojolicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.dojolicense.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long>{

}

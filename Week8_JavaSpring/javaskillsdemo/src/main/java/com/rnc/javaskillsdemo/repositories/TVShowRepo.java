package com.rnc.javaskillsdemo.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.javaskillsdemo.models.TVShow;

@Repository
public interface TVShowRepo extends CrudRepository<TVShow, Long> {

	
}

package com.rnc.javaskillsdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rnc.javaskillsdemo.models.TVShow;
import com.rnc.javaskillsdemo.repositories.ReviewRepo;
import com.rnc.javaskillsdemo.repositories.TVShowRepo;

@Service
public class TVShowService {
	
	@Autowired
	private TVShowRepo tvshowRepo;
	@Autowired
	private ReviewRepo reviewRepo;
	
	public TVShow create(TVShow tvshow) {
		return tvshowRepo.save(tvshow);
	}
	
	public List<TVShow> all() {
		return (List<TVShow>) tvshowRepo.findAll();
	}

	public TVShow findById(Long id) {
		return tvshowRepo.findOne(id);
	}

	public TVShow update(TVShow tvshow) {
		return tvshowRepo.save(tvshow);
		
	}

	public void deleteShow(Long id) {
		reviewRepo.deleteShow(id);
		tvshowRepo.delete(id);
	}
	
}

package com.rnc.javaskillsdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rnc.javaskillsdemo.models.Review;
import com.rnc.javaskillsdemo.repositories.ReviewRepo;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;
	
	public Review create(Review review) {
		return reviewRepo.save(review);
	}

	public List<Review> findByTVShow_idOrderASC(Long id) {
		return reviewRepo.findByTVShow_id(id);
		
	}
	
	
	
}

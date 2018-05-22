package com.rnc.javaskillsdemo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rnc.javaskillsdemo.models.Review;
import com.rnc.javaskillsdemo.models.TVShow;
import com.rnc.javaskillsdemo.services.ReviewService;
import com.rnc.javaskillsdemo.services.TVShowService;

@Controller
public class TVShows {
	@Autowired
	private TVShowService tvshowService;
	@Autowired
	private ReviewService reviewService;

	@RequestMapping("add_show")
	public String add_show(Model model, HttpSession session) {
		model.addAttribute("tvshow", new TVShow());
		return "AddAShow";
	}
	
	@RequestMapping("view/edit/{id}")
	public String editShow(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("tvshow", tvshowService.findById(id));
		return "edit";
	}
	
	@PostMapping("updateshow/{id}")
	public String updateShow(@Valid @ModelAttribute("tvshow") TVShow tvshow, BindingResult result, Model model, HttpSession session, @PathVariable("id")Long id) {
		System.out.println("title "+tvshow.getName());
		if (result.hasErrors()) {
			System.out.println("has errors!");
			return "edit";
		}
		tvshowService.update(tvshow);
		return "redirect:/";
	}
	
	@PostMapping("newshow")
	public String newShow(@Valid @ModelAttribute("tvshow") TVShow tvshow, BindingResult result, Model model, HttpSession session) {
		tvshow.getSubmitter();
		if (result.hasErrors()) {
			return "AddAShow";
		}
		tvshowService.create(tvshow);
		return "redirect:/";
	}
	
	@RequestMapping("view/edit/delete/{id}")
	public String deleteShow(@PathVariable("id") Long id, Model model, HttpSession session) {
		tvshowService.deleteShow(id);
		return "redirect:/";
	}
	
	
	@RequestMapping("view/{id}")
	public String viewShow(@PathVariable("id") Long id, Model model, HttpSession session) {
		model.addAttribute("tvshow", tvshowService.findById(id));
		model.addAttribute("review", new Review());
		System.out.println(reviewService.findByTVShow_idOrderASC(id));
		model.addAttribute("ratings",reviewService.findByTVShow_idOrderASC(id));
		return "view";
	}

	@PostMapping("rate/{id}")
	public String rating(@Valid @ModelAttribute("review") Review review, BindingResult result, Model model, HttpSession session, @PathVariable("id") Long id) {
		System.out.println("rating: "+review.getRating());
		System.out.println("user: "+review.getUser());
		System.out.println("tvshow: "+review.getTvshow());
		if (result.hasErrors()) {
			model.addAttribute("tvshow", tvshowService.findById(id));
			return "view";
		}		
		review.setId(null);
		Review r = reviewService.create(review);
		TVShow t = tvshowService.findById(id);
		List<Review> reviews = t.getReviews();
		Double sum = 0.0;
		for(Review rev: reviews) {
			sum += rev.getRating();
		}
		System.out.println(sum);
		System.out.println(sum/reviews.size());
		t.setAvg_rating(sum/reviews.size());
		tvshowService.update(t);
				
		return "redirect:/";
	}

	
	
}

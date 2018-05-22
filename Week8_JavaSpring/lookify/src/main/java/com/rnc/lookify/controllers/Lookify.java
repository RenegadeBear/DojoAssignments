package com.rnc.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rnc.lookify.models.Song;
import com.rnc.lookify.services.SongService;

@Controller
public class Lookify {
	
	private SongService songService;
	
	public Lookify(SongService songService) {
		this.songService = songService;
	}
	
		
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("lookify")
	public String viewall(Model model, @ModelAttribute("artists") Song song) {
		model.addAttribute("viewall", songService.all());
		return "look";
	}
	
	@RequestMapping("topten")
	public String topten(Model model) {
		model.addAttribute("topten", songService.topten());
		return "top";
	}
	
	@RequestMapping("addsong")
	public String addsong(@ModelAttribute("newsong") Song song) {
		return "newsong";
	}
	
	@RequestMapping("add")
	public String add(@Valid @ModelAttribute("newsong") Song song, BindingResult result) {
		System.out.println(song.getArtist());
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "newsong";
		}
		songService.create(song);
		return "redirect:/lookify";
	}
	
	@RequestMapping(value="/show/{id}")
	public String showSong(Model model, @PathVariable("id") Long id) {
		Song song = songService.findSongById(id);
		model.addAttribute("song", song);
		return "show";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/lookify";
	}

	@RequestMapping(value="/search")
	public String search(Model model, @RequestParam(value="query", required=false) String query) {
		System.out.print(query);
		if(query != null) {
			model.addAttribute("tracks", songService.searchByArtist(query));
		}
		else {
			model.addAttribute("tracks", songService.all());
		}
		return "result";
	}
	
}

package com.rnc.lookify.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rnc.lookify.models.Song;
import com.rnc.lookify.repositories.SongRepo;

@Service
public class SongService {
	
	private SongRepo songRepo;
	
	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}
	
	public Song create(Song song) {
		return songRepo.save(song);
	}
	
	public ArrayList<Song> all() {
		return (ArrayList<Song>) songRepo.findAll();
	}
	
	public void deleteSong(Long id) {
		songRepo.delete(id);
	}
	
	public Song findSongById(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	
	public ArrayList<Song> topten(){
		return (ArrayList<Song>) songRepo.OrderByRatingDesc();
	}
	
	public ArrayList<Song> searchByArtist(String artist) {
		return (ArrayList<Song>) songRepo.findByArtistContaining(artist);
	}
	
}

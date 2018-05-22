package com.rnc.lookify.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rnc.lookify.models.Song;

public interface SongRepo extends CrudRepository<Song ,Long> {

	Optional<Song> findById(Long id);

	@Query(value="SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery=true)
	public ArrayList<Song> OrderByRatingDesc();
	
	public ArrayList<Song> findByArtistContaining(String artist);
	
}

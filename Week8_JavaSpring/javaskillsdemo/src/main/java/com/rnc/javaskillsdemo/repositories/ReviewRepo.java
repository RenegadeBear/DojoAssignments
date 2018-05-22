package com.rnc.javaskillsdemo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rnc.javaskillsdemo.models.Review;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Long> {

	@Query(value="SELECT * FROM reviews WHERE tvshow_id=?1 order by rating",nativeQuery=true)
	List<Review> findByTVShow_id(Long id);

	@Modifying
	@Transactional
	@Query(value="DELETE FROM reviews WHERE tvshow_id=?1", nativeQuery=true)
	void deleteShow(Long id);

}

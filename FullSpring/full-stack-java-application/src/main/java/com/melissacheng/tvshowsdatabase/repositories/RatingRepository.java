package com.melissacheng.tvshowsdatabase.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.tvshowsdatabase.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
	
	List<Rating> findAll();
	
	List<Rating> findByShow_Id(Long showId);

	List<Rating> findByShow_IdOrderByAmountDesc(Long showId);
}

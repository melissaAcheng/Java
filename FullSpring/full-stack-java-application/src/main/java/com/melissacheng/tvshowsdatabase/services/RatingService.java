package com.melissacheng.tvshowsdatabase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.tvshowsdatabase.models.Rating;
import com.melissacheng.tvshowsdatabase.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository repository;
	
	
	public List<Rating> all() {
		return repository.findAll();
	}
	
//	public Rating save(Rating item, Long userId, Long showId, BindingResult result) {
//		
//		if (result.hasErrors()) return null;
//		
//		User user = uService.retrieve(userId);
//		Show show = sService.retrieve(showId);
//		
//		item.setUser(user);
//		item.setShow(show);
//		
//		return repository.save(item);
//
//	}
	
	public Rating save(Rating item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public Rating retrieve(Long itemId) {
		Optional<Rating> optionalRating = repository.findById(itemId);
		if (optionalRating.isPresent()) {
			return optionalRating.get();
		} else {
			return null;
		}
	}
	
	public List<Rating>retrieveByShowId(Long showId) {
		if (showId == null) return null;
		return repository.findByShow_Id(showId);
	}
	
	public List<Rating>retrieveByShowIdInDescOrder(Long showId) {
		if (showId == null) return null;
		return repository.findByShow_IdOrderByAmountDesc(showId);
	}
	
}

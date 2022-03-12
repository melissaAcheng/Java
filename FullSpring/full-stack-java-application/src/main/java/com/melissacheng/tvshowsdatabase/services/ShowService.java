package com.melissacheng.tvshowsdatabase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.melissacheng.tvshowsdatabase.models.Show;
import com.melissacheng.tvshowsdatabase.models.User;
import com.melissacheng.tvshowsdatabase.repositories.ShowRepository;

@Service
public class ShowService {

	@Autowired
	private ShowRepository repository;
	
	@Autowired
	private UserService uService;
	
	
	public List<Show> all() {
		return repository.findAll();
	}
	
	public Show save(Show item, Long userId, BindingResult result) {
		
		Optional<Show>potentialShow = repository.findByTitle(item.getTitle());
		
		if (potentialShow.isPresent()) {
			result.rejectValue("title", "Matches", "Title already in database.");
			return null;
		} else if (result.hasErrors()) {
			return null;
		}
		else {			
			User user = uService.retrieve(userId);
			
			if (user == null) return null;
			
			item.setUser(user);
			
			return repository.save(item);
		}
		
	}
	
	public Show update(Show item, Long userId, BindingResult result) {
		
		Optional<Show>potentialShow = repository.findByTitle(item.getTitle());
		
		if (result.hasErrors()) {
			return null;
		} else if (potentialShow.isPresent() && (item.getId() != potentialShow.get().getId())) {
			result.rejectValue("title", "Matches", "Title already in database.");
			return null;
		} else {			
			User user = uService.retrieve(userId);
			
			if (user == null) return null;
			
			item.setUser(user);
			
			return repository.save(item);
		}
	

	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public Show retrieve(Long itemId) {
		Optional<Show> optionalShow = repository.findById(itemId);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}
	
}

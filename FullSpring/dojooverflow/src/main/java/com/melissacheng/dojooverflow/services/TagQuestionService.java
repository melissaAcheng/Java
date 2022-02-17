package com.melissacheng.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.dojooverflow.models.TagQuestion;
import com.melissacheng.dojooverflow.repositories.TagQuestionRepository;

@Service
public class TagQuestionService {

	@Autowired
	private TagQuestionRepository repository;
	
	public List<TagQuestion> all() {
		return repository.findAll();
	}
	
	public TagQuestion create(TagQuestion item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public TagQuestion retrieve(Long itemId) {
		Optional<TagQuestion> optionalTagQuestion = repository.findById(itemId);
		if (optionalTagQuestion.isPresent()) {
			return optionalTagQuestion.get();
		} else {
			return null;
		}
	}
	
	public TagQuestion save(TagQuestion item) {
		return repository.save(item);
	}
	
	
}

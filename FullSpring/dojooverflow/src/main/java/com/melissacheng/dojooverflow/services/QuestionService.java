package com.melissacheng.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.dojooverflow.models.Question;
import com.melissacheng.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository repository;
	
	
	public List<Question> all() {
		return repository.findAll();
	}
	
	public Question create(Question item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public Question retrieve(Long itemId) {
		Optional<Question> optionalQuestion = repository.findById(itemId);
		if (optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
	public Question save(Question item) {
		return repository.save(item);
	}
	
	
	
}

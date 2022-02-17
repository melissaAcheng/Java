package com.melissacheng.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.dojooverflow.models.Answer;
import com.melissacheng.dojooverflow.models.Question;
import com.melissacheng.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository repository;
	
	@Autowired
	private QuestionService qService;
	
	public List<Answer> all() {
		return repository.findAll();
	}
	
	public Answer create(Long questionId, Answer item) {
		
		Question question = qService.retrieve(questionId);
		item.setQuestion(question);
		
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public Answer retrieve(Long itemId) {
		Optional<Answer> optionalAnswer = repository.findById(itemId);
		if (optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
	}
	
	public Answer save(Answer item) {
		return repository.save(item);
	}

	
}

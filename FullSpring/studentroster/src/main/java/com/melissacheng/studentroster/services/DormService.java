package com.melissacheng.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.studentroster.models.Dorm;
import com.melissacheng.studentroster.repositories.DormRepository;

@Service
public class DormService {

	@Autowired
	private DormRepository dRepository;
	
	
	public List<Dorm> all() {
		return dRepository.findAll();
	}
	
	public Dorm save(Dorm item) {
		return dRepository.save(item);
	}
	
	public void delete(Long itemId) {
		dRepository.deleteById(itemId);
	}
	
	public Dorm retrieve(Long itemId) {
		Optional<Dorm> optionalQuestion = dRepository.findById(itemId);
		if (optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
}

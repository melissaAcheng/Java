package com.melissacheng.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.studentroster.models.Classes;
import com.melissacheng.studentroster.repositories.ClassesRepository;

@Service
public class ClassesService {

	@Autowired
	private ClassesRepository cRepository;
	
	
	public List<Classes> all() {
		return cRepository.findAll();
	}
	
	public Classes save(Classes item) {
		return cRepository.save(item);
	}
	
	public void delete(Long itemId) {
		cRepository.deleteById(itemId);
	}
	
	public Classes retrieve(Long itemId) {
		Optional<Classes> optionalClasses = cRepository.findById(itemId);
		if (optionalClasses.isPresent()) {
			return optionalClasses.get();
		} else {
			return null;
		}
	}
	
	public List<Classes> allExcluding(List<Long>excludeClasses) {
		if ( excludeClasses.size() == 0 ) return this.all();
		return cRepository.findByIdNotIn(excludeClasses);
	}
	
	
	
}

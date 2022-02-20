package com.melissacheng.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.studentroster.models.StudentClass;
import com.melissacheng.studentroster.repositories.StudentClassRepository;

@Service
public class StudentClassService {

	@Autowired
	private StudentClassRepository repository;
	
	
	public List<StudentClass> all() {
		return repository.findAll();
	}
	
	public StudentClass save(StudentClass item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public StudentClass retrieve(Long itemId) {
		Optional<StudentClass> optionalQuestion = repository.findById(itemId);
		if (optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
	public StudentClass retrieveByClassAndStudentId(Long class_id, Long student_id) {
		return repository.findByClasses_IdAndStudent_Id(class_id, student_id);
	}
	
}

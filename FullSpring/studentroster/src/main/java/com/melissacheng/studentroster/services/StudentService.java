package com.melissacheng.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.studentroster.models.Student;
import com.melissacheng.studentroster.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository sRepository;
	
	
	public List<Student> all() {
		return sRepository.findAll();
	}
	
	public Student save(Student item) {
		return sRepository.save(item);
	}
	
	public void delete(Long itemId) {
		sRepository.deleteById(itemId);
	}
	
	public Student retrieve(Long itemId) {
		Optional<Student> optionalQuestion = sRepository.findById(itemId);
		if (optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
	// Gets list of students not in dorms
	public List<Student> getNotInDorms(){
		return sRepository.findByDorm_IdIsNull();
	
}
	
}

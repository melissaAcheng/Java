package com.melissacheng.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.studentroster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student, Long> {
	
	List<Student> findAll();
	
	List<Student> findByDorm_IdIsNull();

}

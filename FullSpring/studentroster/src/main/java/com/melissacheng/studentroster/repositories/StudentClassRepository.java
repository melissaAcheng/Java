package com.melissacheng.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.studentroster.models.StudentClass;

@Repository
public interface StudentClassRepository extends CrudRepository <StudentClass, Long> {
	
	List<StudentClass> findAll();

	StudentClass findByClasses_IdAndStudent_Id(Long class_id, Long student_id);


}

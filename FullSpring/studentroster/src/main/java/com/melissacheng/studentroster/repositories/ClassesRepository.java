package com.melissacheng.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.studentroster.models.Classes;

@Repository
public interface ClassesRepository extends CrudRepository <Classes, Long> {
	
	List<Classes> findAll();
	
	List<Classes> findByIdNotIn(List<Long>excludeClasses);

}

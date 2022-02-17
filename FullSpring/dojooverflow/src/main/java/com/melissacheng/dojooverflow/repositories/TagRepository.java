package com.melissacheng.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository <Tag, Long> {
	
	List<Tag> findAll();
	
	// Finds tag with subject of x
	Optional<Tag> findBySubject(String subject);
}

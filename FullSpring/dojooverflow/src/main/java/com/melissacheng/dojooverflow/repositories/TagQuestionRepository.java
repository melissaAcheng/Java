package com.melissacheng.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.dojooverflow.models.TagQuestion;

@Repository
public interface TagQuestionRepository extends CrudRepository <TagQuestion, Long> {
	
	List<TagQuestion> findAll();
	

}

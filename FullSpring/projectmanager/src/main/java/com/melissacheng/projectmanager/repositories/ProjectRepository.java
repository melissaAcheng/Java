package com.melissacheng.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.projectmanager.models.Project;


@Repository
public interface ProjectRepository extends CrudRepository <Project, Long> {
	
	List<Project> findAll();
	
	List<Project> findByIdIn(List<Long>joinedProjects);
	

}


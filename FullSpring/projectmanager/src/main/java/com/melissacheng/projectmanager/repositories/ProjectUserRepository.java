package com.melissacheng.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.melissacheng.projectmanager.models.ProjectUser;


@Repository
public interface ProjectUserRepository extends CrudRepository <ProjectUser, Long> {
	
	List<ProjectUser> findAll();

	ProjectUser findByProject_IdAndUser_Id(Long project_id, Long user_id);
	
	List<ProjectUser> findByUserIdNot(Long user_id);
}


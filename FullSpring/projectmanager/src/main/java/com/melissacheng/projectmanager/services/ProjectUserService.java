package com.melissacheng.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.projectmanager.models.ProjectUser;
import com.melissacheng.projectmanager.repositories.ProjectUserRepository;

@Service
public class ProjectUserService {
	
	@Autowired
	private ProjectUserRepository repository;
	
	
	public List<ProjectUser> all() {
		return repository.findAll();
	}
	
	public ProjectUser save(ProjectUser item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public ProjectUser retrieve(Long itemId) {
		Optional<ProjectUser> optionalProjectUser = repository.findById(itemId);
		if (optionalProjectUser.isPresent()) {
			return optionalProjectUser.get();
		} else {
			return null;
		}
	}
	
	public ProjectUser retrieveByProjectAndUser(Long projectId, Long userId) {
		return repository.findByProject_IdAndUser_Id(projectId, userId);
	}
	
	public List<ProjectUser>notInProjects(Long userId) {
		return repository.findByUserIdNot(userId);
	}
	
}

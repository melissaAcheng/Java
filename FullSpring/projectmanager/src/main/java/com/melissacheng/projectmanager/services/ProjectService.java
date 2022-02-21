package com.melissacheng.projectmanager.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.projectmanager.models.Project;
import com.melissacheng.projectmanager.models.User;
import com.melissacheng.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository repository;
	
	@Autowired
	private UserService uService;
	
	
	public List<Project> all() {
		return repository.findAll();
	}
	
	public Project save(Project item, Long teamLeadId) {
		User teamLead = uService.retrieve(teamLeadId);
		
		if (teamLead == null) return null;
		
		item.setTeamLead(teamLead);
		
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public Project retrieve(Long itemId) {
		Optional<Project> optionalProject = repository.findById(itemId);
		if (optionalProject.isPresent()) {
			return optionalProject.get();
		} else {
			return null;
		}
	}
	
	public List<Project>joinedProjects(List<Long>joinedProjects) {
		if (joinedProjects.size() == 0) return Collections.emptyList();
		return repository.findByIdIn(joinedProjects);
	}
	
	
}

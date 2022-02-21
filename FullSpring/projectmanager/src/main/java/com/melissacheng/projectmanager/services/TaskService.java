package com.melissacheng.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.projectmanager.models.Task;
import com.melissacheng.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	
	public List<Task> all() {
		return repository.findAll();
	}
	
	public Task save(Task item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public Task retrieve(Long itemId) {
		Optional<Task> optionalTask = repository.findById(itemId);
		if (optionalTask.isPresent()) {
			return optionalTask.get();
		} else {
			return null;
		}
	}
	
}

package com.melissacheng.dojooverflow.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.dojooverflow.models.Tag;
import com.melissacheng.dojooverflow.repositories.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository repository;
	
	public List<Tag> all() {
		return repository.findAll();
	}
	
	public List<String> processTagList(String tags) {
		List<String> tagList = new ArrayList<String>(Arrays.asList(tags.split(",", 3)));
		return tagList;
	}
	
	public Tag create(Tag item) {
		return repository.save(item);
	}
	
	public void delete(Long itemId) {
		repository.deleteById(itemId);
	}
	
	public Tag retrieve(Long itemId) {
		Optional<Tag> optionalTag = repository.findById(itemId);
		if (optionalTag.isPresent()) {
			return optionalTag.get();
		} else {
			return null;
		}
	}
	
	public Tag save(Tag item) {
		return repository.save(item);
	}
	
	public Tag findBySubject(String tag) {
		Optional<Tag> optionalTag = repository.findBySubject(tag);
		if (optionalTag.isPresent()) {
			return optionalTag.get();
		} else {
			return null;
		}
	}
	

	
	
}

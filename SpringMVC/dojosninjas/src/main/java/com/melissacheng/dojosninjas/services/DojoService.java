package com.melissacheng.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.dojosninjas.models.Dojo;
import com.melissacheng.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	DojoRepository dojoRepository;
	
	// Method that calls the query to return all Dojos
		public List<Dojo> allDojos(){
			return dojoRepository.findAll();
		}
		
		// Add an Dojo
		public Dojo addDojo(Dojo Dojo) {
			return dojoRepository.save(Dojo);
		}
		
		// Retrieve one Dojo
		public Dojo findDojo(Long id) {
			Optional<Dojo> optionalDojo = dojoRepository.findById(id);
			if (optionalDojo.isPresent()) {
				return optionalDojo.get();
			} else {
				return null;
			}
		}
		
		// Update Dojo
		public Dojo updateDojo(Dojo Dojo) {
			return dojoRepository.save(Dojo);
		}
		
		// Delete Dojo
		public Dojo deleteDojo(Long id) {
			dojoRepository.deleteById(id);
			return null;
		}
	
}

package com.melissacheng.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.dojosninjas.models.Ninja;
import com.melissacheng.dojosninjas.repositories.NinjaRepository;



@Service
public class NinjaService {

	@Autowired
	NinjaRepository ninjaRepository;
	
	// Method that calls the query to return all Ninjas
		public List<Ninja> allNinjas(){
			return ninjaRepository.findAll();
		}
		
		// Add an Ninja
		public Ninja addNinja(Ninja Ninja) {
			return ninjaRepository.save(Ninja);
		}
		
		// Retrieve one Ninja
		public Ninja findNinja(Long id) {
			Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
			if (optionalNinja.isPresent()) {
				return optionalNinja.get();
			} else {
				return null;
			}
		}
	
		
		// Update Ninja
		public Ninja updateNinja(Ninja Ninja) {
			return ninjaRepository.save(Ninja);
		}
		
		// Delete Ninja
		public Ninja deleteNinja(Long id) {
			ninjaRepository.deleteById(id);
			return null;
		}
	
}

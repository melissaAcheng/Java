package com.melissacheng.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melissacheng.languages.models.Language;
import com.melissacheng.languages.repositories.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	LanguageRepository languageRepository;
	
	// Method to create a language
	public Language addLanguage(Language language) {
		return languageRepository.save(language);
	}

	// Method to retrieve all languages
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	
	// Method to retrieve one language
	public Language oneLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	// Method to update/edit one language
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
	}
	
	
	// Method to delete one language
	public Language deleteLanguage(Long id) {
		languageRepository.deleteById(id);
		return null;
	}
}

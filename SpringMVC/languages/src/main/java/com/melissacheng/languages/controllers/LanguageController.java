package com.melissacheng.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.melissacheng.languages.models.Language;
import com.melissacheng.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	@Autowired
	LanguageService languageService;
	
	@GetMapping("/languages")
	public String index(
			Model model,
			@ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String add(
			Model model,
			@Valid @ModelAttribute("language") Language language,
			BindingResult result) {
		if (result.hasErrors()) {
			List<Language> languages = languageService.allLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		} else {
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String show(
			@PathVariable("id") Long id,
			Model model) {
		Language language = languageService.oneLanguage(id);
		model.addAttribute("language", language);
		
		return "show.jsp";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String edit(
			@PathVariable("id") Long id,
			Model model) {
		Language language = languageService.oneLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("language") Language language,
			BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/{id}")
	public String delete(
			@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
}

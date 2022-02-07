package com.melissacheng.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.melissacheng.dojosninjas.models.Dojo;
import com.melissacheng.dojosninjas.models.Ninja;
import com.melissacheng.dojosninjas.services.DojoService;
import com.melissacheng.dojosninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	// GET - render a create new dojo form
		// use @ModelAttribute to pass in new Dojo object 
	// display a list of dojo locations and a link to see all students at location
		// use view model (Model model) to get all dojos 
	
	@GetMapping("/dojos")
	public String dojos(
			Model model,
			@ModelAttribute("dojo") Dojo dojo) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	@PostMapping("/dojos")
	public String addDojo(
			Model model,
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "index.jsp";
		} else {
			dojoService.addDojo(dojo);
		}
		return "redirect:/dojos";
	}
	
	@GetMapping("/ninjas")
	public String ninjas(
			Model model,
			@ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String addNinja(
			Model model,
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "newNinja.jsp";
		} else {
			ninjaService.addNinja(ninja);
		}
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(
			Model model,
			@PathVariable("id") Long id) {
		System.out.println(id);
		Dojo dojo = dojoService.findDojo(id);
		System.out.println(dojo);
		model.addAttribute("dojo", dojo);
		
		return "showDojo.jsp";
	}

	
}

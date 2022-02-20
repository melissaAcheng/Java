package com.melissacheng.studentroster.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.melissacheng.studentroster.models.Classes;
import com.melissacheng.studentroster.models.StudentClass;
import com.melissacheng.studentroster.services.ClassesService;
import com.melissacheng.studentroster.services.StudentClassService;
import com.melissacheng.studentroster.services.StudentService;

@Controller
@RequestMapping("/classes")
public class ClassesController {
	
	@Autowired
	private ClassesService service;
	
	@Autowired
	private StudentService sService;
	
	@Autowired
	private StudentClassService scService;
	
	@GetMapping("/new")
	public String newClass(
			Model model,
			@ModelAttribute("classClass") Classes classes) {
		
		model.addAttribute("classes", service.all());
		
		return "new_class.jsp";
	}
	
	
	@PostMapping("/add")
	public String create(
			@Valid @ModelAttribute("classClass") Classes classes,
			BindingResult result) {
		
		if (result.hasErrors()) return "new_class.jsp";
		
		service.save(classes);
		
		return "redirect:/classes/new";
	}
	
	@GetMapping("/{id}")
	public String getStudents(
			@PathVariable Long id, 
			Model model) {
		
		model.addAttribute("classClass", service.retrieve(id));
		model.addAttribute("students", sService.all());
		
		return "show_class.jsp";
	}
	
	@GetMapping("/{class_id}/remove/{student_id}")
	public String dropClass(
			@PathVariable Long class_id,
			@PathVariable Long student_id) {

		
		StudentClass studentClass =  scService.retrieveByClassAndStudentId(class_id, student_id);
		
		scService.delete(studentClass.getId());
		
		return String.format("redirect:/students/%d", student_id);
		
	}
}

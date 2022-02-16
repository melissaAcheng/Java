package com.melissacheng.studentroster.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.melissacheng.studentroster.models.Dorm;
import com.melissacheng.studentroster.models.Student;
import com.melissacheng.studentroster.services.DormService;
import com.melissacheng.studentroster.services.StudentService;

@Controller
@RequestMapping("/dorms")
public class DormController {
	
	@Autowired
	private DormService service;
	
	@Autowired
	private StudentService sService;
	

	@GetMapping("/new")
	public String dashboard(
			Model model,
			@ModelAttribute("dorm") Dorm dorm) {
		model.addAttribute("dorms", service.all());
		return "dashboard.jsp";
	}
	
	@PostMapping("/add")
	public String addQuestion(
			@Valid @ModelAttribute("dorm") Dorm dorm,
			BindingResult result) {
		if (result.hasErrors()) {
			return "dashboard.jsp";
		} else {
			service.save(dorm);
		}
		return "redirect:/dorms/new";
//		return String.format("redirect:dorms/{%d}", dorm.getId());
	}
	
	@RequestMapping("/create")
	public String createDorm(@RequestParam(value="name") String name) {
		
		Dorm newDorm = new Dorm();
		
		newDorm.setName(name);
		
		service.save(newDorm);
		
		return "dashboard.jsp";
	}
	
	@RequestMapping("/{id}/add")
	public String addStudent(@PathVariable Long id, @RequestParam(value="student") Long studentId) {
		
		Dorm dorm = service.retrieve(id);
		Student student = sService.retrieve(studentId);
		
		student.setDorm(dorm);
		
		sService.save(student);
		
		return "dashboard.jsp";
		
	}
	
//	@RequestMapping("/{id}/remove")
//	public String removeStudent(@PathVariable Long id, @RequestParam(value="student") Long studentId) {
//		
//		Student student = sService.retrieve(studentId);
//		
//		student.removeDorm();
//		
//		sService.save(student);
//		
//		return "dashboard.jsp";
//		
//	}
	
	@GetMapping("/{dorm_id}/remove/{student_id}")
	public String removeStudent(
			@PathVariable Long dorm_id,
			@PathVariable Long student_id) {
		
		Student student = sService.retrieve(student_id);
		student.removeDorm();
		sService.save(student);
		
		return String.format("redirect:/dorms/%d", dorm_id);
	}
	
	@GetMapping("/{dorm_id}")
	public String showDorm(
			Model model,
			@PathVariable Long dorm_id) {
		
		List<Student> studentsNoDorm = sService.getNotInDorms();
		
		model.addAttribute("dorm", service.retrieve(dorm_id));
		model.addAttribute("students", studentsNoDorm);
		
		return "show_dorm.jsp";
	}
	

	
}

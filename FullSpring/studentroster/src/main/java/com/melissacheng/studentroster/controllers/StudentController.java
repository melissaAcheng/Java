package com.melissacheng.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private DormService dService;
	
	@PostMapping("/add/{dorm_id}")
	public String add(
			@PathVariable Long dorm_id,
			@RequestParam(value="student") Long studentId) {
		
		Dorm dorm = dService.retrieve(dorm_id);
		Student student = service.retrieve(studentId);
		
		student.setDorm(dorm);
		
		service.save(student);
		
		return String.format("redirect:/dorms/%d", dorm_id);
	}
	
}

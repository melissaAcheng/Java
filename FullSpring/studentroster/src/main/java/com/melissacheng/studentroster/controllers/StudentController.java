package com.melissacheng.studentroster.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.melissacheng.studentroster.models.Classes;
import com.melissacheng.studentroster.models.Dorm;
import com.melissacheng.studentroster.models.Student;
import com.melissacheng.studentroster.models.StudentClass;
import com.melissacheng.studentroster.services.ClassesService;
import com.melissacheng.studentroster.services.DormService;
import com.melissacheng.studentroster.services.StudentClassService;
import com.melissacheng.studentroster.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@Autowired
	private DormService dService;
	
	@Autowired
	private ClassesService cService;
	
	@Autowired
	private StudentClassService scService;
	
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
	
	@PostMapping("/{id}/addClass")
	public String addStudentToClass(
			@PathVariable Long id,
			@RequestParam(value="classes") Long classes_id) {
		
	
		Student student = service.retrieve(id);
		Classes classClass = cService.retrieve(classes_id);
		
		StudentClass studentClass = new StudentClass();
		studentClass.setClasses(classClass);
		studentClass.setStudent(student);
		
		scService.save(studentClass);
		
		return String.format("redirect:/students/%d", id);
	}
	
	@GetMapping("/{id}")
	public String show(
			@PathVariable Long id,
			Model model) {
		
		Student student = service.retrieve(id);
		
//		Build a list of class ids that already associated with this student in the many to many table
		List<Long>excludeClasses = new ArrayList<Long>();
		
		for ( StudentClass StudentClass : student.getStudentsClasses() ) {
			excludeClasses.add(StudentClass.getClasses().getId());
		}
		
		model.addAttribute("student", student);
		model.addAttribute("classes", cService.allExcluding(excludeClasses));
		
		return "show_student.jsp";
	}
	
	
}

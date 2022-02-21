package com.melissacheng.projectmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.melissacheng.projectmanager.models.Project;
import com.melissacheng.projectmanager.models.ProjectUser;
import com.melissacheng.projectmanager.models.User;
import com.melissacheng.projectmanager.services.ProjectService;
import com.melissacheng.projectmanager.services.ProjectUserService;
import com.melissacheng.projectmanager.services.UserService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@Autowired
	private ProjectUserService puService;
	
	@Autowired
	private UserService uService;

	@GetMapping("/dashboard")
	public String dashboard(
			HttpSession session,
			Model model) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
//		List of Project Ids from User's ProjectUser table
		List<Long>ProjectsUserJoined = new ArrayList<Long>();
		for (ProjectUser projectUser : user.getProjectUser()) {
			ProjectsUserJoined.add(projectUser.getProject().getId());
		}
		
		model.addAttribute("projectsUserIsIn", service.joinedProjects(ProjectsUserJoined));
		System.out.println(service.joinedProjects(ProjectsUserJoined));
		
		List<Project> allProjects = service.all();
		List<Project> projectsUserAreIn = service.joinedProjects(ProjectsUserJoined);
		
		allProjects.removeAll(projectsUserAreIn);
		
		model.addAttribute("projects", allProjects);
		model.addAttribute("user", user);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/projects/new")
	public String newProject(
			@ModelAttribute("project") Project project,
			HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		return "new_project.jsp";
	}
	
	@PostMapping("projects/add")
	public String addProject(
			@Valid @ModelAttribute("project") Project project,
			BindingResult result,
			HttpSession session,
			Model model) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		if (result.hasErrors()) return "new_project.jsp";
		service.save(project, user.getId());
		
		ProjectUser projectUser = new ProjectUser(user, project);
		puService.save(projectUser);
		
		model.addAttribute("user", user);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/{id}/edit")
	public String editProject(
			Model model,
			@PathVariable Long id,
			HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		model.addAttribute("project", service.retrieve(id));
		return "edit_project.jsp";
		
	}
	
	@PutMapping("/projects/{id}/update")
	public String updateProject(
			Model model,
    		@Valid @ModelAttribute("project") Project project,
    		BindingResult result,
    		@PathVariable Long id,
    		HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		if (result.hasErrors()) return "edit_project.jsp";
		service.save(project, user.getId());
		model.addAttribute("user", user);
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/projects/{id}")
	public String viewProject(
			Model model,
    		@PathVariable Long id,
    		HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		model.addAttribute("user", user);
		model.addAttribute("project", service.retrieve(id));
		return "show_project.jsp";
	}
	
	@GetMapping("/projects/{id}/delete")
	public String deleteProject(
			@PathVariable Long id,
    		HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		service.delete(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/{id}/join")
	public String joinProject(
			HttpSession session, 
    		@PathVariable Long id) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		Project project = service.retrieve(id);
		
		ProjectUser projectUser = new ProjectUser(user, project);
		
		puService.save(projectUser);
		
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/projects/{id}/leave")
	public String leaveProject(
			HttpSession session, 
    		@PathVariable Long id) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		ProjectUser projectUser = puService.retrieveByProjectAndUser(id, user.getId());
				
		puService.delete(projectUser.getId());
		
		
		return "redirect:/dashboard";
		
	}
	
}

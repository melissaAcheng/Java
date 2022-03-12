package com.melissacheng.tvshowsdatabase.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.melissacheng.tvshowsdatabase.models.Rating;
import com.melissacheng.tvshowsdatabase.models.Show;
import com.melissacheng.tvshowsdatabase.models.User;
import com.melissacheng.tvshowsdatabase.services.RatingService;
import com.melissacheng.tvshowsdatabase.services.ShowService;
import com.melissacheng.tvshowsdatabase.services.UserService;

@Controller
@RequestMapping("/shows")
public class ShowController {
	
	@Autowired
	private ShowService service;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private RatingService rService;
	
	@GetMapping("")
	public String dashboard(
			Model model,
			HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		
		model.addAttribute("shows", service.all());
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newShow(
			@ModelAttribute("show") Show show,
			HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		return "new_show.jsp";
	}
	
	@PostMapping("/add")
	public String addShow(
			@Valid @ModelAttribute("show") Show show,
			BindingResult result,
			HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		service.save(show, user.getId(), result);

		if (result.hasErrors()) return "new_show.jsp";
		
		return "redirect:/shows";
		
	}
	
	@GetMapping("/{id}")
	public String displayShow(
			Model model,
			@PathVariable Long id,
			@ModelAttribute("rating") Rating rating,
			HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
//		model.addAttribute("showRatings", rService.retrieveByShowId(id));
		model.addAttribute("showRatings", rService.retrieveByShowIdInDescOrder(id));
		model.addAttribute("show", service.retrieve(id));
		
		return "display_show.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String editShow(
			Model model,
			@PathVariable Long id,
			HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		model.addAttribute("show", service.retrieve(id));
		
		return "edit_show.jsp";
	}
	
	@PutMapping("/{id}/update")
	public String updateShow(
			Model model,
    		@Valid @ModelAttribute("show") Show show,
    		BindingResult result,
    		@PathVariable Long id,
    		HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		service.update(show, user.getId(), result);

		if (result.hasErrors()) return "edit_show.jsp";
		
		return "redirect:/shows";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteShow(
			@PathVariable Long id,
			HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		service.delete(id);
		
		return "redirect:/shows";
	}
	
}

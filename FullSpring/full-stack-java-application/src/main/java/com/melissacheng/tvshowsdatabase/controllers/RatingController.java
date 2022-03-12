package com.melissacheng.tvshowsdatabase.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.melissacheng.tvshowsdatabase.models.Rating;
import com.melissacheng.tvshowsdatabase.models.User;
import com.melissacheng.tvshowsdatabase.services.RatingService;
import com.melissacheng.tvshowsdatabase.services.ShowService;
import com.melissacheng.tvshowsdatabase.services.UserService;

@Controller
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService service;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private ShowService sService;
	
	
	@PostMapping("/{show_id}/add")
	public String addRating(
			Model model,
			@PathVariable Long show_id,
			@Valid @ModelAttribute("rating") Rating rating,
			BindingResult result,
			HttpSession session) {
		
//		Check if user is logged in
		User user = uService.retrieveCurrentUser(session);
		if (user == null) return "redirect:/";
		
		if (result.hasErrors()) {
			return String.format("redirect:/shows/%d", show_id);
		}
		
		Rating newRating = new Rating(rating.getAmount(), user, sService.retrieve(show_id));
		// call service to save new rating
		service.save(newRating);
		
		model.addAttribute("showRatings",service.retrieveByShowId(show_id));
		model.addAttribute("show", service.retrieve(show_id));
		
		
		return String.format("redirect:/shows/%d", show_id);
	}
}

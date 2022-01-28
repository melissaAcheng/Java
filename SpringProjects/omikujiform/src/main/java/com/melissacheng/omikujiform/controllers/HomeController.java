package com.melissacheng.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class HomeController {
	
	// Display Form - GET
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	// Receive user data, store into session, and redirect - POST
	@PostMapping("/submit")
	public String submitForm(
		@RequestParam(value="number") int number,
		@RequestParam(value="city") String city,
		@RequestParam(value="person") String person,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="animal") String animal,
		@RequestParam(value="words") String words,
		HttpSession session) {
		
		// store inputs into the fortune string
		String fortune = String.format("In %d years you will live in %s with %s as your roommate, %s for a living.\nThe next time you see a %s, you will have good luck.\nAlso, %s", number, city, person, hobby, animal, words);
				
		session.setAttribute("fortune", fortune);
		
		return "redirect:/omikuji/show";
	}
	
	// Display fortune using collected user data - GET
	@GetMapping("/show")
	public String showFortune(HttpSession session, Model model) {
		String result = (String) session.getAttribute("fortune");
		model.addAttribute("result", result);
		
		
		return "show.jsp";
	}
		
	
}

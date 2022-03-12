package com.melissacheng.tvshowsdatabase.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.melissacheng.tvshowsdatabase.models.LoginUser;
import com.melissacheng.tvshowsdatabase.models.User;
import com.melissacheng.tvshowsdatabase.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User user,
			@ModelAttribute("newLogin") LoginUser LoginUser) {
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User user,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model,
			HttpSession session) {
		
		service.register(user, result);
		
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("user_id", user.getId());
		
		redirectAttributes.addFlashAttribute("message", "Registration successful!");

		return "redirect:/shows";
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin") LoginUser loginUser,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model,
			HttpSession session) {
		
		User user = service.login(loginUser, result);
		
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		
		redirectAttributes.addFlashAttribute("message", "Welcome back!");
		
		session.setAttribute("user_id", user.getId());
		
		return "redirect:/shows";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
    		session.setAttribute("user_id", null);
    		return "redirect:/";
    }
	
}

package com.melissacheng.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.melissacheng.authentication.models.LoginUser;
import com.melissacheng.authentication.models.User;
import com.melissacheng.authentication.services.UserService;

@Controller
public class HomeController {


	@Autowired
	private UserService userService;
	
	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(
    		@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, 
            Model model, 
            HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	userService.register(newUser, result);
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("id", newUser.getId());
    
        return "redirect:/success";
    }
    
    @PostMapping("/login")
    public String login(
    		@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, 
            Model model, 
            HttpSession session) {
        
        // Add once service is implemented:
    	User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        } 
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("id", user.getId());
        return "redirect:/success";
    }
    
    @GetMapping("/success")
    public String success(
    		Model model,
    		HttpSession session) {
    	if (session.getAttribute("id") == null) {
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
    		return "redirect:/";
    	} else {
    		Long id = (Long) session.getAttribute("id");
    		User user = userService.findUser(id);
    		model.addAttribute("user", user);
    		return "success.jsp";    		
    	}
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.setAttribute("id", null);
    	return "redirect:/";
    }
	
}

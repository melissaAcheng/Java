package com.melissacheng.bookclub.controllers;

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

import com.melissacheng.bookclub.models.Book;
import com.melissacheng.bookclub.models.LoginUser;
import com.melissacheng.bookclub.models.User;
import com.melissacheng.bookclub.services.BookService;
import com.melissacheng.bookclub.services.UserService;

@Controller
public class BookController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
    @GetMapping("/books")
    public String dashboard(
    		Model model,
    		HttpSession session) {
    	if (session.getAttribute("id") == null) {
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
    		return "redirect:/";
    	} else {
    		model.addAttribute("books", bookService.allBooks());
    		Long id = (Long) session.getAttribute("id");
    		User user = userService.findUser(id);
    		model.addAttribute("user", user);
    		return "dashboard.jsp";    		
    	}
    }
    
    @GetMapping("/books/new")
    public String newBook(
    		Model model,
    		@ModelAttribute("book") Book book,
    		HttpSession session) {
    	if (session.getAttribute("id") == null) {
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
    		return "redirect:/";
    	} else {
    		session.getAttribute("id");
    		return "add_book.jsp";
    	}
    }
    
    @PostMapping("/books")
    public String addBook(
    		@Valid @ModelAttribute("book") Book book,
    		BindingResult result,
    		HttpSession session) {
    	if (result.hasErrors()) {
    		return "add_book.jsp";
    	} else {
    		Long user_id = (Long) session.getAttribute("id");
    		bookService.addBook(user_id, book);
    	}
    	return "redirect:/books";
    }
    
    @GetMapping("/books/{id}")
    public String viewBook(
    		Model model,
    		@PathVariable Long id,
    		HttpSession session) {
    	if (session.getAttribute("id") == null) {
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
    		return "redirect:/";
    	} else {
    		session.getAttribute("id");
    		model.addAttribute("book", bookService.findBook(id));
    		return "show_book.jsp";
    	}
    }
	
}

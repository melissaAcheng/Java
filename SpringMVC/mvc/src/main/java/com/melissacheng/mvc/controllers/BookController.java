package com.melissacheng.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.melissacheng.mvc.models.Book;
import com.melissacheng.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		
		
		System.out.println(book);
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
}

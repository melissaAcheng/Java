package com.melissacheng.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.melissacheng.dojooverflow.models.Answer;
import com.melissacheng.dojooverflow.services.AnswerService;
import com.melissacheng.dojooverflow.services.QuestionService;

@Controller
@RequestMapping("/answers")
public class AnswerController {

	@Autowired
	AnswerService service;
	
	@Autowired
	QuestionService qService;
	
	@PostMapping("/add/{question_id}")
	public String add(
			@PathVariable Long question_id,
			@Valid @ModelAttribute("newAnswer") Answer answer,
			BindingResult result) {
		
		if (!result.hasErrors()) {
			
			service.create(question_id, answer);
			
		}
		
		return String.format("redirect:/questions/%d", question_id);
	}
}

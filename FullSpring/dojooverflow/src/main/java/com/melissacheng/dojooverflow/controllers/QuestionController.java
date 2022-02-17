package com.melissacheng.dojooverflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.melissacheng.dojooverflow.models.Answer;
import com.melissacheng.dojooverflow.models.Question;
import com.melissacheng.dojooverflow.models.Tag;
import com.melissacheng.dojooverflow.models.TagQuestion;
import com.melissacheng.dojooverflow.services.QuestionService;
import com.melissacheng.dojooverflow.services.TagQuestionService;
import com.melissacheng.dojooverflow.services.TagService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	QuestionService service;
	
	@Autowired
	TagService tService;
	
	@Autowired
	TagQuestionService tqService;

	@GetMapping("")
	public String dashboard(
			Model model) {
		model.addAttribute("questions", service.all());
		return "dashboard.jsp";
	}
	
	@GetMapping("/{id}")
	public String profile(
			@PathVariable Long id,
			Model model,
			@ModelAttribute ("newAnswer") Answer answer ) {
		
		Question question = service.retrieve(id);
		model.addAttribute("question", question);
		
		return "show_question.jsp";
	}
	
	@GetMapping("/new")
	public String newQuestion() {
		
		return "new_question.jsp";
	}
	
//	TO DO: Add new Question and accept tags
	@PostMapping("/add")
	public String addQuestion(@RequestParam String question, String tags) {
		
		List<String> splicedTags = tService.processTagList(tags);
		Question newQuestion = new Question(question);

		for (String tag : splicedTags)
			if (tService.findBySubject(tag) == null) {
				Tag newTag = new Tag(tag);
				TagQuestion newTagQuestion = new TagQuestion(newTag, newQuestion);
				tqService.create(newTagQuestion);
			} else {
				Tag existingTag = tService.findBySubject(tag);
				TagQuestion newTagQuestion = new TagQuestion(existingTag, newQuestion);
				tqService.create(newTagQuestion);
			}
		
		return "redirect:/questions";
		}
	
}

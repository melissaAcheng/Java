package com.melissacheng.ninjagold.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.melissacheng.ninjagold.models.Plays;

@Controller
public class GameController {
	
	@GetMapping("/gold")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/findGold")
	public String earnGold(
			@RequestParam(value="gold") Integer goldAmount,
			HttpSession session
			) {
		
		@SuppressWarnings("unchecked")
		ArrayList<Plays> plays = (session.getAttribute("plays") == null) ? new ArrayList<Plays>() : (ArrayList<Plays>) session.getAttribute("plays");
		
		plays.add(new Plays(goldAmount, "Farm"));
		session.setAttribute("plays", plays);
		
		
		return "redirect:/play";
	}
	
	@GetMapping("/play")
	public String displayTurn(
			Model model,
			HttpSession session) {
		
		@SuppressWarnings("unchecked")
		ArrayList<Plays> plays = (session.getAttribute("plays") == null) ? new ArrayList<Plays>() : (ArrayList<Plays>) session.getAttribute("plays");
		
		model.addAttribute("plays", plays);
		System.out.println(plays);
		
		int totalCount = Plays.goldCount();
		System.out.println(totalCount);
		model.addAttribute("totalCount", totalCount);
		
		
		return "index.jsp";
	}
}

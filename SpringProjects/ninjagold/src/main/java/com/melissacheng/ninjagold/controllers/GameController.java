package com.melissacheng.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Random;

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
			@RequestParam(value="location") String location,
			HttpSession session
			) {
		
		System.out.println(location);
		
		@SuppressWarnings("unchecked")
		
		ArrayList<Plays> plays = (session.getAttribute("plays") == null) ? new ArrayList<Plays>() : (ArrayList<Plays>) session.getAttribute("plays");
		
		Random random = new Random();
		
		if (location.equals("farm")) {
			int goldAmount = random.nextInt(10,20);
			plays.add(new Plays(goldAmount, "Farm"));
		} else if (location.equals("cave")) {
			int goldAmount = random.nextInt(5,10);
			plays.add(new Plays(goldAmount, "Cave"));
		} else if (location.equals("house")) {
			int goldAmount = random.nextInt(2,5);
			plays.add(new Plays(goldAmount, "House"));
		} else if (location.equals("casino")) {
			int goldAmount = random.nextInt(-50,50);
			plays.add(new Plays(goldAmount, "Casino"));
		}
		
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
	
	@PostMapping("/restart")
	public String restartGame(HttpSession session) {
		if (session.getAttribute("plays") != null) {
			session.invalidate();
			Plays.totalGold = 0;
		}
		return "redirect:/gold";
	}
}

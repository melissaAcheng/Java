package com.melissacheng.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);			
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			System.out.println(currentCount);
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String showCount(HttpSession session, Model model) {
		Integer count = (Integer) session.getAttribute("count");
//		System.out.println(count);
		model.addAttribute("countToShow", count);
		return "counter.jsp";
	}

}

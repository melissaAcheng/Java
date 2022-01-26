package com.melissacheng.displaydate;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
		String curDate = formatter.format(date);
		
		model.addAttribute("date", curDate);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		
		DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
		String time = dateFormat.format(new Date()).toString();
		
		model.addAttribute("time", time);
		
		
		return "time.jsp";
	}
}

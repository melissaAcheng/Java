package com.melissacheng.hopperreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
			
		String name = "Melissa Cheng";
		String itemName = "Malibu Rum";
		double price = 20.75;
		String description = "Great for making pina coladas";
		String vendor = "Wine and Liquors";
		
		// Add your code here. Add values to the view model to be rendered
		model.addAttribute("name", name);
		model.addAttribute("item", itemName);
		model.addAttribute("price", price);
		model.addAttribute("description", description);
		model.addAttribute("vendor", vendor);
		
		return "index.jsp";
	}
}

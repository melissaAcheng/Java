package com.melissacheng.daikichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String searchQuery1,
						@RequestParam(value="last_name", required=false) String searchQuery2,
						@RequestParam(value="times", required=false) int number 
			) {
		if (searchQuery1 == null && searchQuery2 == null) {
			return "Hello Human";
		} else if (searchQuery1 != null && searchQuery2 != null) {
			return "Hello " + searchQuery1 + " " + searchQuery2;
		} else {
			String greeting = "";
			for (int i = 0; i < number; i++) {
				String text = "Hello " + searchQuery1 + " ";
				greeting += text;
			}
			return greeting;
		}
	}
}

package com.busyvacation.happyclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	@RequestMapping(value="/")
	public String home() {
		return "index";
	}
//	@RequestMapping("/test")
//	public String test(Model model) {
//		String[] toStudy= {"java","python","kotline","swift"};
//		User user = new User("u1","user","u1@gmail.com","1234");
//		model.addAttribute("user", user);
//		model.addAttribute("admin", false);
//		model.addAttribute("toStudy", toStudy);
//		return "test";
//	}
}

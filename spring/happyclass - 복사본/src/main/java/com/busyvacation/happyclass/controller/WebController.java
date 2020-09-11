package com.busyvacation.happyclass.controller;

import java.security.Principal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.busyvacation.happyclass.db.dto.User;

@Controller
public class WebController {

	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}

	@RequestMapping("/test")
	public String test(Model model) {
		String[] toStudy = { "java", "python", "kotlin", "swift" };
		User user = new User("u1", "user", "u1@mail.com", "1234");
		model.addAttribute("user", user);
		model.addAttribute("admin", false);
		model.addAttribute("toStudy", toStudy);
		return "test";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
//	@RequestMapping(value = "/")
//	public String index(Principal user) {
//		UserDetails u = (UserDetails) user;
//		return "index";
//	}
}

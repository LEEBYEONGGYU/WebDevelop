package com.securitytest.controller;

import java.security.Principal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping(value = "/")
	public String home() {
		return "index";
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

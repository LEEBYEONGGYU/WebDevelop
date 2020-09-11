package com.mtbcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/")
@Controller
public class WebController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/intro")
	public String intro() {
		return "/intro";
	}
	@RequestMapping("/update")
	public String updateintro() {
		return "update";
	}
}

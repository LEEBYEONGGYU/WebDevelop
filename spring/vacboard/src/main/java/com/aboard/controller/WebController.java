package com.aboard.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class WebController {
	@RequestMapping(value="/")
	public String main() throws Exception{
		
		return "index";
	}
}

package com.aboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class LoginController {
	@RequestMapping(value="/login")
	public String login() throws Exception{
		return "/page/member/loginForm";
	}
	@RequestMapping(value="/loginok")
	public String loginok() throws Exception{
		return "/page/member/loginOk";
	}
	@RequestMapping(value="/logout")
	public String logout() throws Exception{
		return "/page/member/logout";
	}
}

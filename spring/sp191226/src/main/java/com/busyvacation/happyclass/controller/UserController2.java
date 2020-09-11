package com.busyvacation.happyclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.busyvacation.happyclass.db.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController2 {
	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String userList(Model model) {
		try {
			model.addAttribute("userList", userService.getUsers());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userlist";
	}


}
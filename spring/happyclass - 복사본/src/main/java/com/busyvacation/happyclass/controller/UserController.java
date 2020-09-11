package com.busyvacation.happyclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.busyvacation.happyclass.db.repository.UserJpaRepository;
import com.busyvacation.happyclass.db.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	UserJpaRepository userRepository;

	@RequestMapping("/")
	public String userList(Model model) {
		try {
			model.addAttribute("userList", userService.getUsers());
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "userlist";
	}

	@RequestMapping("/jpalist")
	public String jpaUserList(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		return "userlist";
	}
}
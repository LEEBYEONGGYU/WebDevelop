package com.winter.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.winter.db.dto.User;
import com.winter.spring.db.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	private ArrayList<User> list;

	public UserController() {
		list = new ArrayList<User>();
		User u1 = new User("1", "user1", "u1@mail.com", "1111");
		User u2 = new User("2", "user2", "u2@mail.com", "2222");
		list.add(u1);
		list.add(u2);
	}
	

	@RequestMapping("/")
	public String userList(Model model) {
		try {
			model.addAttribute("userList",userService.getUsers());
			} catch (Exception e) {
			e.printStackTrace();
			}
		return "userlist";
	}

	@RequestMapping("/{userId}")
	public String user(@PathVariable("userId") String userId, Model model) {
		return "user";
	}
	
}
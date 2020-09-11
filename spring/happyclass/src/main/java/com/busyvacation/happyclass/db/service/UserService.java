package com.busyvacation.happyclass.db.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busyvacation.happyclass.db.dto.User;
import com.busyvacation.happyclass.db.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public ArrayList<User> getUsers() throws Exception {
		return userMapper.getUsers();
	}

	public User getUser(String userId) {
		return userMapper.getUser(userId);
	}
}
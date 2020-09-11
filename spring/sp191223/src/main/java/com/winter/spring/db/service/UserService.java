package com.winter.spring.db.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winter.db.dto.User;
import com.winter.spring.db.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	public ArrayList<User> getUsers() throws Exception {
		return userMapper.getUsers();
	}
}
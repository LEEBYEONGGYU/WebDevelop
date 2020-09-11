package com.winter.spring.db.mapper;

import java.util.ArrayList;

import com.winter.db.dto.User;

public interface UserMapper {
	public ArrayList<User> getUsers() throws Exception;
}

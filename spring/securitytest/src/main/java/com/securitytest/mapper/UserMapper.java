package com.securitytest.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.securitytest.dto.User;


public interface UserMapper {
public ArrayList<User> getUsers() throws Exception;
public User getUser(@Param("id") String id);

}
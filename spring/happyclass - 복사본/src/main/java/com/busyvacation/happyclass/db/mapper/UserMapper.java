package com.busyvacation.happyclass.db.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.busyvacation.happyclass.db.dto.User;

public interface UserMapper {
public ArrayList<User> getUsers() throws Exception;
public User getUser(@Param("id") String id);

}
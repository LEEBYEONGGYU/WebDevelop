package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Board;
import com.example.demo.dto.Member;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {
	@Resource(name="com.example.demo.mapper.MemberMapper")
	@Autowired
	MemberMapper memberMapper;

	public void insertMember(Member member) throws Exception {
		memberMapper.insertMember(member);
		
	}

	public Object LoginOk(Member mem) {
		// TODO Auto-generated method stub
		return memberMapper.LoginOk(mem);
		
	}

}

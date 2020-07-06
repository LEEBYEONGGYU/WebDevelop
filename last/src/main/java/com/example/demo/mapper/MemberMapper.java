package com.example.demo.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Member;

@Repository("com.example.demo.mapper.MemberMapper")
public interface MemberMapper {

	void insertMember(Member member) throws Exception;

	Object LoginOk(Member mem);
	
}
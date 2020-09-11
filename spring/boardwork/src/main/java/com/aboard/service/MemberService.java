package com.aboard.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aboard.memberdao.MemberDao;
import com.aboard.model.MemberModel;

@Service
public class MemberService {

//@Resource(name="com.aboard.memberdao")

MemberDao mMemberMapper;
	
	public String MemberInsertService(MemberModel member) throws Exception {
		return mMemberMapper.MemberInsert(member);
		
	}
}

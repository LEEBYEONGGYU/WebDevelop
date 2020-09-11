package com.aboard.memberdao;


import org.springframework.stereotype.Repository;

import com.aboard.model.MemberModel;

@Repository("com.mtbcraft.dao")
public interface MemberDao {
	
	//회원가입
	public String MemberInsert(MemberModel member) throws Exception;
}

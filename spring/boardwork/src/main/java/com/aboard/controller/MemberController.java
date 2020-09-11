package com.aboard.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aboard.model.MemberModel;
import com.aboard.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/join")
	public String login() {
		
		return "/page/member/joinForm";
	}
	
	@RequestMapping("/loginOk")
	public String loginok(HttpServletRequest request) throws Exception {
		
		MemberModel member = new MemberModel();
		
		member.setMemberid(request.getParameter("username"));
		member.setMemberpw(request.getParameter("userpw"));
		
		 memberService.MemberInsertService(member);
		
		return "redirect:/";
	}
}

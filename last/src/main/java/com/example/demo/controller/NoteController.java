package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;
import com.example.demo.service.NoteService;

@Controller
@RequestMapping("/note/")
public class NoteController {

	@Autowired
	NoteService noteService;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("main")
	public String noteMain() {
		return "/note/main";
	}
	
	@RequestMapping("member")
	public String noteMember() {
		return "/note/member";
	}
	
	@RequestMapping("join_ok")
	public String noteJoinOk(HttpServletRequest request) throws Exception {
		Member member = new Member();
		member.setUserid(request.getParameter("userid"));
		member.setUserpw(request.getParameter("userpw"));
		
		memberService.insertMember(member);
		return "redirect:/note/main";
	}
	
}

package com.example.demo.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.Board;
import com.example.demo.dto.Create_Board;
import com.example.demo.dto.Member;
import com.example.demo.service.BoardService;
import com.example.demo.service.MemberService;


@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member")
	public String init() throws Exception {
		return "/member";
	}
	
	@RequestMapping("/memberok")
	public String memberOk(HttpServletRequest request) throws Exception {
		
		Member member = new Member();
		member.setUserid(request.getParameter("userid"));
		member.setUserpw(request.getParameter("userpw"));
		
		System.out.println(request.getParameter("userid") + request.getParameter("userpw") );
		memberService.insertMember(member);
		return "redirect:/";
	}
	
	@RequestMapping("/loginok")
	public String LoginOk(HttpServletRequest request) throws Exception {
		
		Member mem = new Member();
		mem.setUserid(request.getParameter("userid"));
		mem.setUserpw(request.getParameter("userpw"));
		
		System.out.println(request.getParameter("userid")+ " " + request.getParameter("userpw"));
		
		memberService.LoginOk(mem);
		HttpSession session = request.getSession();
		session.setAttribute("User",memberService.LoginOk(mem));
		
		System.out.println(session.getAttribute("User"));
		return "redirect:/";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
}

package com.mtbcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ComunityController {
	
	/* 
	// 커뮤니티
	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String comunity() {
		
		return "/community";
	}

	// 커뮤니티 클럽
	@RequestMapping(value = "/community/club", method = RequestMethod.GET)
	public String comunityclub() {
		return "/community/club/club";
	}

	// 커뮤니티 클럽 만들기
	@RequestMapping(value = "/community/club/create", method = RequestMethod.GET)
	public String clubcreate(int result) {
		return "/community/club/create";
	}

	// 커뮤니티 클럽 가입
	@RequestMapping(value = "/community/club/join", method = RequestMethod.GET)
	public String clubjoin(int result, String message) {
		return "/community/club/join";
	}

	// 커뮤니티 클럽 가입
	@RequestMapping(value = "/community/club/join", method = RequestMethod.POST)
	public String clubjoinpost(int result, String CB_name, String userid) {
		return "/community/club/join";
	}

	// 클럽 게시판
	@RequestMapping(value = "/community/club/clubboard", method = RequestMethod.GET)
	public String clubboard(int result, String CB_name, String b[]) {
		return "/community/club/myclub/clubboard";
	}

	// 클럽 게시판 검색
	@RequestMapping(value = "/community/club/myclub/clubboard/search", method = RequestMethod.GET)
	public String clubcreatepost(int result, String CB_num, String keyword, String type, String b[]) {
		return "/community/club/myclub/clubboard/search";
	}

	// 클럽 게시판 글쓰기
	@RequestMapping(value = "/community/club/myclub/clubboard/posting", method = RequestMethod.POST)
	public String clubcreatepost(int result, String B_title, String B_content, String B_file) {
		return "/community/club/myclub/clubboard/posting";
	}

	// 클럽 캘린더
	@RequestMapping(value = "/community/club/myclub/calender", method = RequestMethod.GET)
	public String clubcalender(int result, String CB_num, String CB_name, String CB_image, String CC[]) {
		return "/community/club/myclub/calender";
	}
	*/
	
	//  SNS
	@RequestMapping(value = "/community/sns", method = RequestMethod.GET)
	public String snsget() {
		return "/community/sns";
	}
		
	// SNS
	@RequestMapping(value = "/community/sns", method = RequestMethod.POST)
	public String snspost(int result, String B_area, String B_title, String B_content, String B_file) {
		return "/community/sns";
	}

	// 중고거래 GET
	@RequestMapping(value = "/community/trade", method = RequestMethod.GET)
	public String tradeget() {
		return "/community/trade";
	}

	// 중고거래 글쓰기 POST
	@RequestMapping(value = "/community/trade/posting", method = RequestMethod.POST)
	public String tradeposting(int result, String B_area, String B_title, String B_file, String price, String date) {
		return "/community/trade/posting";
	}
}
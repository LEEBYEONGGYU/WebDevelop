package com.aboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aboard.model.BoardModel;
import com.aboard.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String init(Model model) throws Exception {
		model.addAttribute("list",boardService.boardListService());
		return "index";
	}
	
	@RequestMapping("/posts")
	public String write() {
		return "page/board/write";
	}
	
	@RequestMapping("/posts/{bno}")
	public String read(@PathVariable int bno, Model model) throws Exception {
		System.out.println(boardService.boardDetailService(bno));
		model.addAttribute("detail",boardService.boardDetailService(bno));
		return "page/board/read";
	}
	
	@RequestMapping("/put/{bno}")
	public String put(@PathVariable int bno, Model model) throws Exception {
		
		model.addAttribute("edit",boardService.boardDetailService(bno));
		return "page/board/put";
	}
	
	//게시글 수정
	@RequestMapping("/edit/edit")
	public String edit(HttpServletRequest request) throws Exception {
		BoardModel board = new BoardModel();
		board.setIdx(Integer.parseInt(request.getParameter("idx")));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		boardService.boardUpdateService(board);
		return "redirect:/page/board/read/"+request.getParameter("idx");
	}
	
	//게시글 삭제
	@RequestMapping("/posts/delete/{bno}")
	public String delete(@PathVariable int bno) throws Exception{
		boardService.boardDeleteService(bno);
		return "redirect:/";
	}
	
	@RequestMapping("/posts/post")
	public String writeok(HttpServletRequest request) throws Exception{
		
		BoardModel board = new BoardModel();
		board.setPostid(request.getParameter("postid"));
		board.setTitle(request.getParameter("title"));
		board.setMemberid(request.getParameter("memberid"));
		board.setContent(request.getParameter("content"));
		
		boardService.boardInsertService(board);
		return "redirect:/";
	}
}
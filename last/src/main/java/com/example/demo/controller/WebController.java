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
import com.example.demo.dto.Like;
import com.example.demo.dto.Reply;
import com.example.demo.service.BoardService;

@Controller
public class WebController {
	@Autowired
	BoardService boardService;

	@RequestMapping("/")
	public String init(Model model) throws Exception {
		model.addAttribute("list", boardService.boardListService());
		return "index";
	}

	@RequestMapping("/posts")
	public String write() {
		return "page/board/write";
	}

	// 게시글 읽기
	@RequestMapping("/read/{bno}")
	public String read(@PathVariable int bno, Model model) throws Exception {
		boardService.updatehit(bno);
		model.addAttribute("detail", boardService.boardDetailService(bno));
		model.addAttribute("detail_reply", boardService.getReplyService(bno));
		model.addAttribute("cho_list",boardService.getCholist(bno));
		model.addAttribute("cho_list_jun",boardService.getCholist_jun(bno));
		return "/board/read";
	}

	// 게시글 수정
	@RequestMapping("/edit/{idx}")
	public String edit(@PathVariable int idx, Model model) throws Exception {
		model.addAttribute("edit", boardService.boardDetailService(idx));
		return "/board/edit";
	}

	// 게시글 수정 처리
	@RequestMapping("/editok")
	public String editok(HttpServletRequest request) throws Exception {
		Board board = new Board();
		board.setIdx(Integer.parseInt(request.getParameter("idx")));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));

		boardService.boardUpdateService(board);
		return "redirect:/read/" + request.getParameter("idx");
	}

	// 게시글 삭제
	@RequestMapping("/delete/{bno}")
	public String delete(@PathVariable int bno) throws Exception {
		boardService.boardDeleteService(bno);
		return "redirect:/";
	}

	// 게시글 쓰기
	@RequestMapping("/posts/post")
	public String writeok(HttpServletRequest request, @RequestParam("put_file") MultipartFile file1) throws Exception {
		try {

			Board board = new Board();
			board.setTitle(request.getParameter("title"));
			board.setName(request.getParameter("postid"));
			board.setContent(request.getParameter("content"));
			
			String lock = request.getParameter("lock_post");
			if(lock==null) {
				lock = "0";
			}else {
				lock = "1";
			}
			
			board.setLock_post(Integer.parseInt(lock));
			board.setPassword(request.getParameter("lock_password"));

			if (request.getParameter("put_file") != null) {
				System.out.println("파일있음");
			} else {
				System.out.println(file1.getOriginalFilename());
				board.setPut_file(file1.getOriginalFilename());
			}

			boardService.boardInsertService(board);

			file1.transferTo(new File("D:/upload/" + file1.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}

	//글잠금
	@RequestMapping("lock/{bno}")
	public String lockpost(@PathVariable int bno, Model model) throws Exception {
		model.addAttribute("idx", bno);
		return "/board/lock";
	}
	
	//글잠금
		@RequestMapping("lockok/{bno}")
		public String lockpostok(@PathVariable int bno, HttpServletRequest request) throws Exception {
			System.out.println(bno);
			String pw = request.getParameter("pw");
			Board board = new Board();
			board.setIdx(bno);
			board.setPassword(pw);
			boardService.checkpw(board);
			
			
			return "redirect:/read/"+bno;
		}
		
	
	// 댓글작성
	@RequestMapping("/reply_ok/{bo_num}")
	public String replyOk(HttpServletRequest request, @PathVariable int bo_num) throws Exception {

		Reply reply = new Reply();
		reply.setBo_num(bo_num);
		reply.setName(request.getParameter("dat_user"));
		reply.setPassword(request.getParameter("dat_pw"));
		reply.setContents(request.getParameter("content"));

		boardService.insertReply(reply);
		return "redirect:/read/" + bo_num;
	}
	
	

	// 댓글 수정
	@RequestMapping("/reply_modify_ok")
	public String replyModify(HttpServletRequest request) throws Exception {

		Reply reply = new Reply();
		reply.setIdx(Integer.parseInt(request.getParameter("rno")));
		reply.setPassword(request.getParameter("pw"));
		reply.setContents(request.getParameter("content"));

		boardService.modifyReply(reply);
		return "redirect:/read/" + request.getParameter("b_no");
	}

	// 댓글삭제
	@RequestMapping("/reply_delete/{reply_idx}/{board_idx}")
	public String deleteReply(@PathVariable int reply_idx, @PathVariable int board_idx) throws Exception {
		boardService.deleteReply(reply_idx);
		return "redirect:/read/" + board_idx;
	}
	
	//추천박자
	@RequestMapping("/like")
	public String likeHit(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		
		String userid = request.getParameter("userid");
		String type = request.getParameter("type");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		Like like = new Like();
		like.setIdx(Integer.parseInt(request.getParameter("idx")));
		like.setUserid(userid);
		like.setType(type);
		
		System.out.println(userid + " " + type + " " + idx);
		
		if(type.equals("전문가")) {
			boardService.likeHit(like);
			boardService.likeHitinsert(like);
		}else {
			boardService.likeHitPer(like);
			boardService.likeHitinsert(like);
		}
		return "redirect:/read/"+idx;
	}
}

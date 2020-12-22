package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Note;
import com.example.demo.dto.Search;
import com.example.demo.service.NoteService;

@Controller
public class WebContoller {
	
	@Autowired
	NoteService noteService;
	
	
	@RequestMapping("/")
		public String main(Model model) throws Exception {
		
//		model.addAttribute("list", noteService.getList());
		return "index";
	}
	
	
	@RequestMapping("/page/note/rec_note")
	public String rec_note() {
		return "/page/note/rec_note";
	}
	@GetMapping("/page/note/send_note")
	public String send_note() {
		return "/page/note/send_note";
	}
	
	@GetMapping("/page/note/write")
	public String write_note() {
		return "/page/note/write";
	}
	@PostMapping("/page/note/write_ok")
	public String note_write_ok(HttpServletRequest request) {
		Note note = new Note();
		note.setSend_id(request.getParameter("userid"));
		note.setTitle(request.getParameter("title"));
		note.setContent(request.getParameter("content"));
		note.setRecv_id(request.getParameter("recv_id"));
		
		System.out.println(request.getParameter("recv_id") + " " + request.getParameter("title"));
		
		noteService.sendNote(note);
		noteService.recv_note(note);
		
		return "/page/note/write_ok";
	}
	@GetMapping("/page/note/adress_import")
	public String adress_import() {
		return "/page/note/adress_import";
	}
}

package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Note;
import com.example.demo.dto.Search;
import com.example.demo.mapper.NoteMapper;

@Service
public class NoteService {
	
	@Autowired
	private NoteMapper noteMapper;
	



	public void sendNote(Note note) {
		// TODO Auto-generated method stub
		noteMapper.sendNote(note);
	}


	public void recv_note(Note note) {
		// TODO Auto-generated method stub
		noteMapper.recvNote(note);
	}


	public List<Note> getRecvList(String recv_id) throws Exception {
		// TODO Auto-generated method stub
		return noteMapper.getRecvList(recv_id);
	}
	public List<Note> getSendList(String send_id) throws Exception {
		// TODO Auto-generated method stub
		return noteMapper.getSendList(send_id);
	}
	public List<Note> getRead(int idx) throws Exception {
		// TODO Auto-generated method stub
		return noteMapper.getRead(idx);
	}
}

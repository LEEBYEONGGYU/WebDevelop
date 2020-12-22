package com.example.demo.service;

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
	

	public String getList() throws Exception {
		return noteMapper.getList();
	}


	public void sendNote(Note note) {
		// TODO Auto-generated method stub
	}


	public void recv_note(Note note) {
		// TODO Auto-generated method stub
	
	}
}

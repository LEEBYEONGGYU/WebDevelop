package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.Note;
import com.example.demo.dto.Search;

@Repository("com.example.demo.mapper.NoteMapper")
public interface NoteMapper {
	//검색
	public String getList() throws Exception;

	public void sendNote(Note note);

	public void recvNote(Note note);
}

package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.Note;
import com.example.demo.dto.Search;

@Repository("com.example.demo.mapper.NoteMapper")
public interface NoteMapper {
	public void sendNote(Note note);

	public void recvNote(Note note);

	public List<Note> getRecvList(String recv_id) throws Exception;
	public List<Note> getSendList(String send_id) throws Exception;

	public List<Note> getRead(int idx) throws Exception;
}

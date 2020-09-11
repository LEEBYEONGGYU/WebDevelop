package com.aboard.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import com.aboard.model.BoardModel;

@Repository("com.aboard.dao")
public interface BoardDao {
	//게시판 리스트
	public List<BoardModel> boardList() throws Exception;
	
	//글 쓰기
	public String boardinsert(BoardModel board) throws Exception;
	
	//글 읽기
	public BoardModel boardDetail(int bno) throws Exception;
	
	//글 수정
	public String BoardUpdate(BoardModel board) throws Exception;
	
	//글 삭제
	public String BoardDelete(int bno) throws Exception;
}

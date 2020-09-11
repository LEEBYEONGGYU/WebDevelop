package com.aboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.aboard.dao.BoardDao;
import com.aboard.model.BoardModel;
@Service
public class BoardService {
	@Resource(name="com.aboard.dao")
	BoardDao mBoardMapper;
	
	public List<BoardModel> boardListService() throws Exception {
		return mBoardMapper.boardList();
	}
	
	public BoardModel boardDetailService(int bno) throws Exception {
		
		return mBoardMapper.boardDetail(bno);
	}
	public String boardUpdateService(BoardModel board) throws Exception{
		return mBoardMapper.BoardUpdate(board);
	}
	
	public String boardDeleteService(int bno) throws Exception {
		return mBoardMapper.BoardDelete(bno);
	}

	public String boardInsertService(BoardModel board) throws Exception {
		return mBoardMapper.boardinsert(board);
		
	}
}

package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.Board;
import com.example.demo.dto.Create_Board;
import com.example.demo.dto.Like;
import com.example.demo.dto.Reply;
import com.example.demo.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	@Resource(name="com.example.demo.mapper.BoardMapper")
	@Autowired
	BoardMapper boardMapper;

	public List<Board> boardListService() throws Exception {
		return boardMapper.boardList();
	}
	
	public Board boardDetailService(int bno) throws Exception {
		
		return boardMapper.boardDetail(bno);
	}
	public String boardUpdateService(Board board) throws Exception{
		return boardMapper.BoardUpdate(board);
	}
	
	public String boardDeleteService(int bno) throws Exception {
		return boardMapper.BoardDelete(bno);
	}

	public String boardInsertService(Board board) throws Exception {
		return boardMapper.boardinsert(board);
		
	}

	public List<Reply> getReplyService(int bno) {
		// TODO Auto-generated method stub
		return boardMapper.getReply(bno);
	}

	public String insertReply(Reply reply) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.insertReply(reply);
		
	}

	public String modifyReply(Reply reply) {
		return boardMapper.modifyReply(reply);
		
	}

	public int deleteReply(int reply_idx) {
		return boardMapper.deleteReply(reply_idx);
		
	}

	public int updatehit(int bno) {
		return boardMapper.updatehit(bno);
		
	}

	public int likeHit(Like like) {
		return 		boardMapper.likeHit(like);
		
	}

	public int likeHitinsert(Like like) {
		// TODO Auto-generated method stub
		return boardMapper.likeHitinsert(like);
	}

	public int likeHitPer(Like like) {
		// TODO Auto-generated method stub
		return boardMapper.likeHitPer(like);
		
	}


	public void checkpw(Board board) {
		// TODO Auto-generated method stub
		boardMapper.checkpw(board);
	}
}

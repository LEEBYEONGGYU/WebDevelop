package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.dto.Board;
import com.example.demo.dto.Chochen;
import com.example.demo.dto.Create_Board;
import com.example.demo.dto.Like;
import com.example.demo.dto.Reply;

@Repository("com.example.demo.mapper.BoardMapper")
public interface BoardMapper {

	//게시판 리스트
		public List<Board> boardList() throws Exception;
		
		//글 쓰기
		public String boardinsert(Board board) throws Exception;
		
		//글 읽기
		public Board boardDetail(int bno) throws Exception;
		
		//글 수정
		public String BoardUpdate(Board board) throws Exception;
		
		//글 삭제
		public String BoardDelete(int bno) throws Exception;

		public List<Reply> getReply(int bno);

		public String insertReply(Reply reply) throws Exception;

		public String modifyReply(Reply reply);

		public int deleteReply(int reply_idx);

		public int updatehit(int bno);

		public int likeHit(Like like);

		public void likeHitinsert(Like like);

		public int likeHitPer(Like like);


		public void checkpw(Board board);

		public List<Chochen> getCholist(int bno);

		public List<Chochen> getCholist_jun(int bno);

}

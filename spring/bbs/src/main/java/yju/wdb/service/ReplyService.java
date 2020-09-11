package yju.wdb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yju.wdb.domain.Criteria;
import yju.wdb.domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);
	public ReplyVO get(int rno);
	public int remove(int rno);
	public int modify(ReplyVO vo);
	public List<ReplyVO> getList(@Param("crt") Criteria crt, @Param("bno") int bno);
	
}

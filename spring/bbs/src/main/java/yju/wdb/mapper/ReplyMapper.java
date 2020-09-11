package yju.wdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import yju.wdb.domain.Criteria;
import yju.wdb.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public ReplyVO read(int rno);
	public int delete(int rno);
	public int update(ReplyVO vo);
	public List<ReplyVO> getListWithPaging(@Param("crt") Criteria crt, @Param("bno") int bno);
	
	
}

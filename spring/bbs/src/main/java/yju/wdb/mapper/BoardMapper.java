package yju.wdb.mapper;

import java.util.List;

// import org.apache.ibatis.annotations.Select;

import yju.wdb.domain.BoardVO;
import yju.wdb.domain.Criteria;

public interface BoardMapper {

	// @Select("select * from tbl_board")
	public List<BoardVO> getlist();
	
	public void insert(BoardVO vo);
	
	public void insertSelectKey(BoardVO vo);
	
	public BoardVO read(int bno);
	
	public int delete(int bno);
	
	public int update(BoardVO vo);
	
	public List<BoardVO> getListWithPaging(Criteria crt);
	
	public int getTotalCount(Criteria crt);
	
	public List<BoardVO> getListWithPagingNSearch(Criteria crt);
	
	public int getTotalCountWithSearch(Criteria crt);
}

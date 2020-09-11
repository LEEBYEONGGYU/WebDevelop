package yju.wdb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yju.wdb.domain.BoardVO;
import yju.wdb.domain.Criteria;
import yju.wdb.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardMapper mapper;
	
	/*
	public BoardServiceImpl(BoardMapper mapper) {
		this.mapper = mapper;
	}
	*/
	
	@Override
	public void register(BoardVO board) {
		logger.info("register....." + board);
		//mapper.insert(board);
		mapper.insertSelectKey(board);

	}

	@Override
	public BoardVO get(int bno) {
		logger.info("get........" + bno);
		return null;
	}

	@Override
	public void modify(BoardVO board) {
		logger.info("modify....." + board);
		mapper.update(board);

	}

	@Override
	public void remove(int bno) {
		logger.info("remove...." + bno);
		mapper.delete(bno);

	}

	/*
	@Override
	public List<BoardVO> getList() {
		logger.info("getList........");
		return mapper.getlist();
	}
*/
	@Override
	public List<BoardVO> getList(Criteria crt) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(crt);
	}

	@Override
	public int getTotal(Criteria crt) {
		logger.info("get total count");
		return mapper.getTotalCount(crt);
	}

}

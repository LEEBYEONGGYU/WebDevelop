package yju.wdb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yju.wdb.domain.Criteria;
import yju.wdb.domain.ReplyVO;
import yju.wdb.mapper.ReplyMapper;

@Service
public interface ReplyServiceImpl extends ReplyService {
	@Autowired
	private ReplyMapper mapper;
	private Logger log = LoggerFactory.getLogger(ReplyServiceImpl.class);
	@Override
	default int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("register...."+vo);
		return mapper.insert(vo);
	}

	@Override
	default ReplyVO get(int rno) {
		// TODO Auto-generated method stub
		log.info("get....."+rno);
		return mapper.read(rno);
	}

	@Override
	default int remove(int rno) {
		// TODO Auto-generated method stub
		Log.info("remove...."+rno);
		return mapper.delete(rno);
	}

	@Override
	default int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		log.info("modify,..."+vo);
		return mapper.update(vo);
	}

	@Override
	default List<ReplyVO> getList(Criteria crt, int bno) {
		// TODO Auto-generated method stub
		log.info("getList...."+bno);
		return mapper.getListWithPaging(crt, bno);
	}
	
}

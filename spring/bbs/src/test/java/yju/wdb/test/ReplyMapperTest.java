package yju.wdb.test;

import java.util.List;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import yju.wdb.domain.Criteria;
import yju.wdb.domain.ReplyVO;
import yju.wdb.mapper.ReplyMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTest {
	@Autowired
	private ReplyMapper mapper;
	Logger log = Logger.getLogger(BoardMapperTest.class);
	@Test
	public void testMapper() {
		log.info(mapper.getClass().getName());
	}
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			vo.setBno(3971);
			vo.setReply("댓글 테스트"+i);
			vo.setReplyer("댓글내용 테스트"+i);
			mapper.insert(vo);
		});
	}
	
	//@Test
	public void testRead() {
		int rno = 5;
		ReplyVO vo=mapper.read(rno);
		log.info(vo);
		
	}
	
	@Test
	public void testDelete() {
		int rno = 1;
		int result = mapper.delete(rno);
		log.info("#of deleted records : "+result);
	}
	
	@Test
	public void testUpdate() {
		int rno = 10;
		ReplyVO vo = mapper.read(rno);
		log.info("수정전: "+vo);
		vo.setReply("Update Reply");
		int result = mapper.update(vo);
		vo = mapper.read(rno);
		log.info("#of updated records : " + result + ", 수정후: " +vo);
				
	}
	
	@Test
	public void testList() {
		Criteria crt = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(crt,  3931);
		replies.forEach(reply -> log.info(reply));
	}
}

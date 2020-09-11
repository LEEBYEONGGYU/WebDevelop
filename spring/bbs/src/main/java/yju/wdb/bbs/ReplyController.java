package yju.wdb.bbs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yju.wdb.domain.Criteria;
import yju.wdb.domain.ReplyVO;
import yju.wdb.service.ReplyService;

@RequestMapping("/replies")
@RestController
public class ReplyController {
	
	private Logger log = LoggerFactory.getLogger(ReplyController.class);
	@Autowired
	private ReplyService service;
	
	@PostMapping(value="/new", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("replyVO: " +vo);

		int result = service.register(vo);
		
		log.info("register result:"+result);
		return result >= 1? new ResponseEntity<>("Success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping(value="/pages/{bno}/{page}", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("bno") int bno){
		log.info("getList............");
		Criteria crt = new Criteria(page, 10);
		return new ResponseEntity<>(service.getList( crt, bno), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/{rno}", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") int rno){
		log.info("getList............"+rno);
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") int rno){
		log.info("getList............"+rno);
		return service.remove(rno) >= 1? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value="/{rno}", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") int rno){
		vo.setRno(rno);
		log.info("modify......"+rno);
		return service.modify(vo) >= 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

package edu.hi.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hi.ex.service.BoardService;
import edu.hi.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;




//1.json으로 서비스 하기
@Slf4j
@RequestMapping("/boards")
@RestController
public class RestBoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public List<BoardVO> list(Model model){
		log.info("list() ..");
		
		return service.getList();		
	}
	
	//http://localhost:8282/boards/905
	@GetMapping("/{bid}")
	public BoardVO rest_content_view(BoardVO boardVO){
		log.info("rest_content_view() ..");
		
		return service.read(boardVO.getBid());		
	}
	
	//http://localhost:8282/boards/905	
	@DeleteMapping("/{bid}")
	public int rest_delete(BoardVO boardVO){
		
		log.info("rest_delete..");
		int rn = service.remove(boardVO);
			
		return rn;		
	}
	
	//http://localhost:8282/boards/905	
	@PutMapping("/{bid}")
	public ResponseEntity<String> rest_update(@RequestBody BoardVO boardVO){
		
		log.info("rest_update() ..");
		ResponseEntity<String> entity = null;
		System.out.println(boardVO);
		try {
			int rn = service.modify(boardVO);
			log.info("Update 넘어온 숫자:::" + rn );
			
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);			
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;		
	}
	
	//post + "/boards"  +  "/"  + 
	@PostMapping("/")
	public ResponseEntity<String> rest_write(@RequestBody BoardVO boardVO){
		
		log.info("rest_write() .." + boardVO);
		
		ResponseEntity<String> entity = null;
				
		try {
				service.register(boardVO);
				entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);			
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;		
	}
	
	
	@GetMapping("/")
	public String home() {
		return "<h1>안녕하세요</h1>";
	}

	
	
}

package edu.hi.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hi.ex.page.Criteria;
import edu.hi.ex.page.PageVO;
import edu.hi.ex.service.BoardService;
import edu.hi.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list() ..");
		
		model.addAttribute("boardList",service.getList());		
		
		return "list";
	}
	
	//http://localhost:8282/list2
	//list2?pageNum=5&amount=10">1</a>
	@GetMapping("/list2")
	public String list2(Criteria cri, Model model) {
		log.info("list2() ..");
		log.info("list2() Criteria " + cri);		
		
		model.addAttribute("list",service.getList(cri));
		
		int total = service.getTotal();
		log.info("total" + total);			
		
		model.addAttribute("pageMaker", new PageVO(cri, total));	
		
		return "list2";
	}
	
	
	
	//http://localhost:8282/content_view?bid=10
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO,Model model) {
		log.info("content_view() ..");
		
		int bid = boardVO.getBid();
		
		model.addAttribute("content_view",service.read(bid));		
		
		return "content_view";// content_view.jsp로 가라는 뜻
	}
	
	@GetMapping("/write_view")
	public String write_view() {
		log.info("write_view() ..");
		
		return "write_view";// write_view.jsp로 가라는 뜻
	}
	
	/*
    	유저로 하여금 list를 다시 치고 들어오도록 redirect해준다.
    	redirect:list를 리턴해주게 되면 BoardController에서 list로 받는 메소드를 타게 된다.
    */
	@PostMapping("/write")
	public String write(BoardVO boardVO) {
		log.info("write() ..");
		
		service.register(boardVO);
		
		return "redirect:list"; 
	}

	@PostMapping("/modify")
	public String modify(BoardVO boardVO) {
		log.info("modify() ..");
		
		int rn = service.modify(boardVO);
		
		log.info("modify() .. result number::" + rn);
		
		return "redirect:list"; 
	}
	
	//http://localhost:8282/delete?bid=28
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete() ..");
		
		int rn = service.remove(boardVO);
		
		log.info("delete() .. result number::" + rn);
		
		return "redirect:list"; 
	}

	//http://localhost:8282/reply_view?bid=7
	@GetMapping("/reply_view")	
	public String reply_view(BoardVO boardVO,Model model) {
		log.info("reply_view() ..");
		
		model.addAttribute("reply_view", service.read(boardVO.getBid()));
				
		return "reply_view"; 
	}
	
	//http://localhost:8282/reply
	//post방식으로 보냈으므로 PostMapping으로 받는다.
	@PostMapping("/reply")	
	public String reply(BoardVO boardVO) {
		log.info("reply() ..");
		
		service.registerReply(boardVO);
				
		return "redirect:list"; //로직 수행한 후 list로 redirect해준다.
	}
	
}

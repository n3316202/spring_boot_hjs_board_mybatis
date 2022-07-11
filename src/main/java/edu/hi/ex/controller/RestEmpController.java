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
import org.springframework.web.servlet.ModelAndView;

import edu.hi.ex.service.BoardService;
import edu.hi.ex.service.EmpService;
import edu.hi.ex.vo.BoardVO;
import edu.hi.ex.vo.EmpDeptVO;
import lombok.extern.slf4j.Slf4j;

//1.json으로 서비스 하기
@Slf4j
@RequestMapping("/emps")
@RestController
public class RestEmpController {

	@Autowired
	private EmpService service;
	
	@GetMapping("/list")
	public List<EmpDeptVO> list(Model model){
		log.info("list() ..");
		
		return service.getEmpDeptList();	
	
	}
	
	@GetMapping("/cart4")
	public ModelAndView cart4(ModelAndView mv){
		log.info("cart4() ..");
		mv.setViewName("cart4");
		
		return mv;	
	}
}

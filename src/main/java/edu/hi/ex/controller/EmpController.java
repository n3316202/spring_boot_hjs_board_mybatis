package edu.hi.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hi.ex.page.Criteria;
import edu.hi.ex.page.PageVO;
import edu.hi.ex.service.BoardService;
import edu.hi.ex.service.EmpService;
import edu.hi.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService service;
	

	//emp/list
	@GetMapping("/list")
	public String list(Model model) {
		log.info("list() ..");
		
		model.addAttribute("list",service.getEmpDeptList());		
		
		return "empList";
	}
	
	//emp/list
	@GetMapping("/list2")
	public String list2(Model model) {
		log.info("list() ..");
		
		model.addAttribute("list",service.getEmpDetpList2());		
		
		return "empList2";
	}
	
}

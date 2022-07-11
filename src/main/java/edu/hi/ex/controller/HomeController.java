package edu.hi.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/user/userHome")
	public String userHome() {
		log.info("userHome ...");
		return "/user/userHome";
	}
	
	@GetMapping("/admin/adminHome")
	public void adminHome() {
		log.info("adminHome ...");
	}
	
	@GetMapping("/member/memberHome")
	public void memberHome() {
		log.info("memberHome ...");
	}
	
	
	//컨트롤러가 @RestController 일때 jsp로 서비스하는(return) 방법
	@GetMapping("/index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
	

}

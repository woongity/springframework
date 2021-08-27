package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
// 공통경로 지정.
@RequestMapping("/ch02")
public class Ch02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch02Controller.class);
	//annotation request mapping.
	@RequestMapping("/content")
	public String home() {
		logger.info("실행");
		return "ch02/content";
	}
	@GetMapping("/method")
	public String method1() {
		return "redirect:/ch02/content";
	}
	@PostMapping("/method")
	public String method2() {
		return "redirect:/ch02/content";
	}
	
	@PutMapping("/method")
	public String method3() {
		return "redirect:/ch02/content";
	}
	@DeleteMapping("/method")
	public String method4() {
		return "redirect:/ch02/content";
	}
/*@GetMapping("/modelandview")
	public String methods(){
		logger.info
	}
 * 	
 */
	@GetMapping("/modelandview")
	public ModelAndView methods(){
		logger.info("실헹");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ch02/modelandview");
		return modelAndView;
	}
	@PostMapping("/login1")
	public String login1() {
		logger.info("실행");
		return "ch02/loginResult";
	}
	@PostMapping("/login2")
	public String login2() {
		logger.info("실행");
		return "redirect:/ch01/content";
	}
	
	@GetMapping("/boardList")
	public String boardList() {
		return "ch02/boardList";
	}
	@GetMapping("/boardwriteform")
	public String boardwWriteForm() {
		return "ch02/boardWriteForm";
	}
	@PostMapping("/boardwrite")
	public String boardWrite() {
		return "redirect:/ch02/boardList";
	}
}

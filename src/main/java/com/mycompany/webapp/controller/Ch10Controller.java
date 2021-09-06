package com.mycompany.webapp.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.exception.Ch10SoldoutException;

@Controller
@RequestMapping("/ch10")
public class Ch10Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "/ch10/content";
	}
	@RequestMapping("/handlingException1")
	public String handlingException1() {
		logger.info("실행");
		try {
			
		}catch(Exception e) {
			
		}
		return "redirect:/ch10/content";
		
	}
	@RequestMapping("/handlingException2")
	public String handlingException2(String data) {
		
		if(data.equals("java")) {
			
		}
		return "redirect:/ch10/content";
	}
	@RequestMapping("/handlingException3")
	public String handlingException3() {
		Object data ="abc";
		Date date = (Date)data;

		return "redirect:/ch10/content";
	}
	@RequestMapping("/handlingException4")
	public String handlingException4() {
		int[] arr = {0,2,3};
		arr[5] = 0;
		return "redirect:/ch10/content";
	}
	@RequestMapping("/handlingException5")
	public String handlingException5() {
		int stock = 0;
		if(stock==0) {
			throw new Ch10SoldoutException("상품의 제고가 없음");
		}
		return "redirect:/ch10/content";
	}
}

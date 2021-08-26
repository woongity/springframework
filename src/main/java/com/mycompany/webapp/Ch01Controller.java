package com.mycompany.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ch01")
public class Ch01Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch01Controller.class);
	//annotation request mapping.
	@RequestMapping("/content")
	public String home() {
		logger.info("실행");
		return "ch01/content";
	}
	@RequestMapping("/login")
	public String login() {
		logger.info("실행");
		return "ch01/login";
	}
	
}

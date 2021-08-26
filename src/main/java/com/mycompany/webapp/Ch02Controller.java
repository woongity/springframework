package com.mycompany.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch02Controller.class);
	//annotation request mapping.
	@RequestMapping("/content")
	public String home() {
		logger.info("실행");
		return "ch02/content";
	}
	
}

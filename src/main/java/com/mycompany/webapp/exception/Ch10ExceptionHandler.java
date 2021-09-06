package com.mycompany.webapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class Ch10ExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(Ch10ExceptionHandler.class);
	
	public Ch10ExceptionHandler() {
		logger.info("실행");
	}
	
	@ExceptionHandler
	public String handleNullPointerException(NullPointerException e) {
		logger.info("실행");
		return "error/500";
	}
	@ExceptionHandler
	public String handleClassCastException(ClassCastException e) {
		logger.info("실행");
		return "error/500";
	}
	@ExceptionHandler
	public String handleArrayOutOfBoundException(ArrayIndexOutOfBoundsException e) {
		logger.info("실행");
		return "error/500";
	}
	
	@ExceptionHandler
	public String handleSoldoutException(Ch10SoldoutException e) {
		logger.info("실행");
		return "error/soldout";
	}
}

package com.mycompany.webapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Ch13BoardDao2 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13BoardDao2.class);
	public Ch13BoardDao2() {
		// TODO Auto-generated constructor stub
		logger.info("실행");
	}
}
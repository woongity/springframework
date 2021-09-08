package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// service는 root에서관리하도록 한다.
public class Ch13Service1 {
	private static final Logger logger= LoggerFactory.getLogger(Ch13Service1.class);
	public Ch13Service1() {
		logger.info("실행");
	}
}

package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.webapp.dao.Ch13BoardDao1;

// service는 root에서관리하도록 한다.
public class Ch13Service1 {
	private static final Logger logger= LoggerFactory.getLogger(Ch13Service1.class);
	public Ch13Service1() {
		logger.info("실행");
	}
	
	Ch13BoardDao1 ch13BoardDao1;
	public void method1() {
		logger.info("실행");
	}
	public void setCh13BoardDao1(Ch13BoardDao1 ch13BoardDao1) {
		logger.info("실행");
		this.ch13BoardDao1 = ch13BoardDao1;
	}

}

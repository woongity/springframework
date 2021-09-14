package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13BoardDao2;

@Service
// service는 root에서관리하도록 한다.
public class Ch13Service2 {
	private static final Logger logger= LoggerFactory.getLogger(Ch13Service2.class);
	Ch13BoardDao2 ch13BoardDao2;
	
	@Autowired
	public Ch13Service2(Ch13BoardDao2 ch13BoardDao2) {
		logger.info("실행");
		this.ch13BoardDao2 = ch13BoardDao2;
	}
	public void method1() {
		logger.info("실행");
	}
	public Ch13Service2() {
		logger.info("실행");
	}
}

package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.mycompany.webapp.dao.Ch16AccountDao;

@Service
public class Ch16AccountService {
	private static final Logger logger = LoggerFactory.getLogger(Ch16AccountService.class);
	public enum TransferResult{
		SUCCESS,
		FAIL_NOT_FOUND_ACCOUNT,
		FAIL_NOT_ENOUGH_BALANCE
	}
	@Resource
	Ch16AccountDao accountDao;
	@Resource
	TransactionTemplate transactionTemplate;
}

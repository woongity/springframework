package com.mycompany.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14Member;

@Repository
public class Ch14MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberDao.class);

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	public void insert(Ch14Member member) {
		// 예외 발생
		sqlSessionTemplate.insert("member.insert", member);
	}

	public Ch14Member selectByMid(String mid) {
		Ch14Member member= sqlSessionTemplate.selectOne("member.selectByMid", mid);
		return member;
	}
	
	public String selectPasswordById(String mid) {
		String pw = sqlSessionTemplate.selectOne("member.selectPasswordById",mid);
		return pw;
	}
}

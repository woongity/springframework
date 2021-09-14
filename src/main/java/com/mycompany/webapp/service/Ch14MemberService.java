package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch14MemberDao;
import com.mycompany.webapp.dto.Ch14Member;

@Service
public class Ch14MemberService {
	private static final Logger logger = LoggerFactory.getLogger(Ch14MemberService.class);
	// 열거타입 선언
	public enum JoinResult{
		SUCCESS,
		FAIL,
		DUPLIACTED,
	}
	
	public enum LoginResult{
		SUCCESS,
		EMPTYSET,
		WRONGPASSWORD,
		NOTREGISTERED,
		FAIL
	}
	@Resource
	private Ch14MemberDao memberDao;
	
	// 회원 가입을 처리하는 비지니스 로직(메소드)
	public JoinResult join(Ch14Member member) {
		//이미 가입된 아이디 인지 확인
		Ch14Member dbMember = memberDao.selectByMid(member.getMid()); // select * from member where mid = ?
		if(dbMember==null) {
			try {
				memberDao.insert(member);
				
				return JoinResult.SUCCESS;
			}catch (Exception e) {
				return JoinResult.FAIL;
				// TODO: handle exception
			}
		}
		else {
			return JoinResult.DUPLIACTED;
		}
		//회원 정보를 저장
	}
	//로그인 처리 로직
	public LoginResult login(Ch14Member member) {
		
		// 해당아이디에 저장되어있는 패스워드
//		String registeredPassword = memberDao.selectPasswordById(member.getMid());
		// 해당 아이디에 저장 되어잇는 계정 객체
		try {
			Ch14Member dbMember = memberDao.selectByMid(member.getMid());
			if(member.getMid()==null || member.getMpassword()==null) {
				return LoginResult.EMPTYSET;
			}
		// 회원 가입이 되지않은회원
			else if(dbMember==null) {
				return LoginResult.NOTREGISTERED;
			}
			// 비밀번호 틀림
			else if(!dbMember.getMpassword().equals(member.getMpassword())){
				return LoginResult.WRONGPASSWORD;
			}else {
				return LoginResult.SUCCESS;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return LoginResult.FAIL;
			// TODO: handle exception
		}
	}
}

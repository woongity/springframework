package com.mycompany.webapp.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.ws.Response;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@RequestMapping("/ch05")
public class Ch05Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch05Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch05/content";
	}
	@GetMapping("/getHeaderValue")
	public String getHeaderValue(HttpServletRequest request) {
		logger.info("실행");
		
		logger.info("method: " + request.getMethod());
		logger.info("requestURI: " + request.getRequestURI());
		logger.info("client IP: " + request.getRemoteAddr());
		logger.info("contextRoot: " + request.getContextPath());
		
		String userAgent = request.getHeader("User-Agent");
		logger.info("User-Agent: " + userAgent);
		if(userAgent.contains("Windows NT")) {
			logger.info("client OS: Windows");
		} else if(userAgent.contains("Macintosh")) {
			logger.info("client OS: macOS");
		}
			
		if(userAgent.contains("Edg")) {
			logger.info("client Browser: Edge");
		} else if(userAgent.contains("Trident")) {
			logger.info("client Browser: IE11");
		} else if(userAgent.contains("Chrome")) {
			logger.info("client Browser: Chrome");
		} else if(userAgent.contains("Safari")) {
			logger.info("client Browser: Safari");
		}
		
		
		return "redirect:/ch05/content";
	}
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		logger.info("쿠키 생성 완료");
		Cookie cookie  = new Cookie("useremail", "ytw1122@gmail.com");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		cookie.setMaxAge(30*60);
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/getCookie1")
	public String getCookie1(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("useremail")) {
				logger.info( cookie.getName()+":"+cookie.getValue());
			}
		}
		return "redirect:/ch05/content";
	}
	@GetMapping("/getCookie2")
	public String getCookie2(@CookieValue String useremail, @CookieValue("useremail") String uemail) {
		logger.info("useremail"+uemail);
		logger.info("uemail"+uemail);
		return "redirect:/ch05/content";
	}
	@GetMapping("/createJsonCookie")
	public String createjsonCookie(HttpServletResponse response) throws Exception {
		logger.info("실행");
		
		// String json = "{\"userid\":\"fall\", \"useremail\":\"fall@company.com\", \"username\":\"홍길동\"}";
		
		// 위와 동일한 결과를 얻을 수 있음!
		JSONObject jsonObject = new JSONObject(); // 생성
		jsonObject.put("userid", "fall");
		jsonObject.put("useremail", "fall@company.com");
		jsonObject.put("username", "홍길동");
		String json = jsonObject.toString();
		logger.info("json: " + json);
		json = URLEncoder.encode(json, "UTF-8"); // "로 인한 오류 때문에인코딩!
		logger.info("json: " + json);		
		Cookie cookie = new Cookie("user", json);
		response.addCookie(cookie);
		
		return "redirect:/ch05/content";		
	}
	
	@GetMapping("/getJsonCookie")
	public String getJsonCookie(@CookieValue String user) {
		logger.info("json쿠키 읽기");
		JSONObject jsonObject = new JSONObject(user);
		logger.info("userid :"+jsonObject.getString("userid"));
		logger.info("useremail :"+jsonObject.getString("useremail"));
		logger.info("username :"+jsonObject.getString("username"));
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/getJwtCookie")
	public String getJwtCookie(@CookieValue String jwt) throws UnsupportedEncodingException {
		logger.info("실행");
		JwtParser parser = Jwts.parser();
		String scretKey = "abc12345";
		parser.setSigningKey(scretKey.getBytes("UTF-8"));
		Jws<Claims> jws = parser.parseClaimsJws(jwt);
		Claims claims = jws.getBody();
		String userid = claims.get("userid", String.class);
		String useremail = claims.get("useremail", String.class);
		String username = claims.get("username", String.class);		
		logger.info("userid: " + userid);
		logger.info("useremail: " + useremail);
		logger.info("username: " + username);
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/createJwtCookie")
	public String createJwtCookie(HttpServletResponse response) {
		logger.info("실행");
		String userid = "fall";
		String useremail = "fall@naver.com";
		String username = "홍길동";
		
		JwtBuilder builder = Jwts.builder();
		builder.setHeaderParam("alg", "HS256");
		builder.setHeaderParam("typ", "JWT");
		builder.setExpiration(new Date(new Date().getTime() + 1000*60*30)); // 지금으로부터 30분 제한 시간 
		
		builder.claim("username", username);
		builder.claim("useremail", useremail);
		builder.claim("userid", userid);
		
		String secretKey = "abc12345";
		builder.signWith(SignatureAlgorithm.HS256, secretKey.getBytes());
		String jwt = builder.compact();
		logger.info("jwt : "+jwt);
		
		Cookie cookie = new Cookie("jwt",jwt);
		response.addCookie(cookie);
		return "redirect:/ch05/content";
	}
	

}

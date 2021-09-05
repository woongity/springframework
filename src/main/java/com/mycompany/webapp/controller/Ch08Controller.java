package com.mycompany.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
	private static Logger logger = LoggerFactory.getLogger(Ch08Controller.class); 

	@GetMapping(value = "/saveData", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String saveData(String name, HttpServletRequest request, HttpSession session) {
		logger.info("실행");
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("name", name);
		String json = jsonObject.toString();
		session.setAttribute("json",json);
		return json;
	}
	
	@GetMapping(value="/readData",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String readData(HttpSession session,  @SessionAttribute String name) {
		logger.info("실행");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		String json = jsonObject.toString();
		return json;
	}
	
	@RequestMapping("/content")
	public String content() {
		return "ch08/content";
	}
	@GetMapping("/login")
	public String loginForm() {
		logger.info("get 실행");
		return "ch08/loginForm";
	}
	@PostMapping("/login")
	public String login(String mid, String mpassword,HttpSession session) {
		logger.info("post 실행");
		if(mid.equals("spring") && mpassword.equals("12345")) {
			session.setAttribute("sessionMid", mid);
			logger.info("로그인 성공!");
		}
		logger.info("로그인 실패");
		return "redirect:/ch08/content";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		logger.info("로그아웃 되었습니다");
		session.invalidate();
		session.removeAttribute("sessionMid");
		return "redirect:/ch08/content";
	}
	@PostMapping("/loginAjax")
	@ResponseBody
	public String loginAjax(String mid, String mpassword,HttpSession session) {
		String result = "";
		if(!mid.equals("Spring")) {
			result = "wrongId";
		}else if(!mpassword.equals("123456")) {
			result = "wrongPassword";
		}else {
			result = "success";
			session.setAttribute("sessionMid", mid);
		}
		String json = new JSONObject().put("result", result).toString();
		return json;
	}
	
	@GetMapping("/logoutAjax")
	@ResponseBody
	public String logoutAjax(HttpSession session) {
		logger.info("실행");
		session.invalidate();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		String json = jsonObject.toString();
		return json;
	}
}

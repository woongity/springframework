package com.mycompany.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch08Controller.class);
	@RequestMapping("/content")
	public String content() {
		logger.info("실행");
		return "/ch08/content";
	}
	
	@GetMapping(value="/saveData",produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String saveData(String name, HttpSession session, HttpServletRequest request ) {
		JSONObject jsonObject = new JSONObject();
		session.setAttribute("name", name);
		jsonObject.put("result", "success");
		String json = jsonObject.toString();
		return json;
	}
	@GetMapping(value="/readData", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String readData(HttpSession session) {
		String name = (String)session.getAttribute("name");
		logger.info(name);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		String json = jsonObject.toString();
		return json;
	}
	
	@GetMapping("/login")
	public String login() {
		return "/ch08/loginForm";
	}
	
	@PostMapping(value = "/loginAjax", produces= "application/json; charset=UTF-8")
	@ResponseBody
	public String loginAjax(String mid, String mpassword,HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		logger.info("실행");
		if(!mid.equals("spring")) {
			jsonObject.put("result", "wrongMid");
		}else if(!mpassword.equals("12345")) {
			jsonObject.put("result", "wrongMpassword");
		}else {
			jsonObject.put("result", "success");
		}
		String json = jsonObject.toString();
		return json;
	}
	@GetMapping("/logoutAjax")
	@ResponseBody
	public void logoutAjax(HttpServletResponse response,HttpSession session) throws IOException {
		session.invalidate();
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("resutl", "success");
		String json = jsonObject.toString();
		pw.print(json);
	}
}

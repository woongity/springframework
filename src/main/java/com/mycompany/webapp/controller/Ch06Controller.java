package com.mycompany.webapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	
	public static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch06/content";
	}
	
	@RequestMapping("/forward")
	public String forward() {
		return "ch06/forward";
	}
	
	// redirect
	@RequestMapping("/redirect")
	public String redirect() {
		return "ch06/redirect";
	}
	
	// getFragmentHtml
	@GetMapping("/getFragmentHtml")
	public String getFragmentHtml() {
		return "ch06/fragmentHtml";
	}
	
	@GetMapping("/getJson1")
	public void getJson1(HttpServletResponse response) throws Exception{
		logger.info("실행");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo5.jpg");
		
		String json = jsonObject.toString();
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		pw.println(json);
		pw.flush();
		pw.close();
	}
	@GetMapping(value = "/getJson2", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String getJson2() {
		logger.info("실행");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo6.jpg");
		String json = jsonObject.toString();
		return json;
	}
}

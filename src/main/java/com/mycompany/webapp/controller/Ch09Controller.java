package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	final static String PATH ="/Users/andy/Desktop/hyundaiIT/upload_files/";
	private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);
	@RequestMapping("/content")
	public String content() {
		return "ch09/content";
	}
	
	@PostMapping("/fileuploadAjax")
	@ResponseBody
	public String fileuploadAjax(String title, String desc, MultipartFile attach) throws Exception, IOException {
		String savedName = new Date().getTime()+attach.getOriginalFilename();
		File file = new File(PATH+savedName);
		attach.transferTo(file);
		logger.info(title);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result","success");
		jsonObject.put("savedFile", "success");
		String json = jsonObject.toString();
		
		return json;
	}
	@PostMapping("/fileupload")
	public String fileupload(String title, String desc, MultipartFile attach) throws Exception, Exception {
		logger.info(attach.getOriginalFilename());
		logger.info(attach.getContentType());
		logger.info("file size :"+attach.getSize());
		
		String savedName= new Date().getTime()+attach.getOriginalFilename();
		File file = new File("/Users/andy/Desktop/hyundaiIT/upload_files/"+savedName);
		attach.transferTo(file);
		return "redirect:/ch09/content";
	}
	
	@RequestMapping("/filedownload")
	public void filedownload(String savedName, HttpServletResponse response,@RequestHeader("User-Agent") String userAgent) throws Exception {
		String contentType = "image/jpeg";
		String originalFileName = "photo10.jpg";
		String name = savedName;
		
		response.setContentType(contentType);
		// 브라우저별로 한글 파일명을 변환
		if(userAgent.contains("Trident") || userAgent.contains("MSIE")) {
			originalFileName = URLEncoder.encode(originalFileName,"UTF-8");
		}else {
			//크롬에서 한글 파일명을 변경
			originalFileName = new String(originalFileName.getBytes("UTF-8"),"ISO-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment; filename=\""+originalFileName+"\"");
		String filePath = PATH+originalFileName;
		InputStream is = new FileInputStream(filePath);
		
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(is, os);
		
		is.close();
		os.flush();
		os.close();
	}
}

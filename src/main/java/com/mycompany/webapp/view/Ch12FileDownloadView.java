package com.mycompany.webapp.view;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.mycompany.webapp.controller.Ch12Controller;

@Component
public class Ch12FileDownloadView extends AbstractView {
	private static final Logger logger = LoggerFactory.getLogger(Ch12Controller.class);
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		logger.info("실행");
		String fileName = (String) model.get("fileName");
		String userAgent = (String) model.get("userAgent");
		String contenttype = request.getServletContext().getMimeType(fileName);
		String originalFileName = fileName;

		// 응답 바디의 데이터의 형식
		response.setContentType(contenttype);
		
		// 브라우저별로 한글 파일명을 변환
		if (userAgent.contains("Trident") || userAgent.contains("MSIE")) {
			originalFileName = URLEncoder.encode(originalFileName, "UTF-8");
		} else {
			// 크롬에서 한글 파일명을 변경
			originalFileName = new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		// 파일 첨부로 다운로드

		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFileName + "\"");

		// 파일로부터 데이터를 읽는 입력 스트림 생성

		String filePath = "/Users/andy/Desktop/hyundaiIT/upload_files/" + originalFileName;
		InputStream is = new FileInputStream(filePath);

		// 응답바디에 출력하는 출력스트림 얻기
		OutputStream os = response.getOutputStream();
		// 입력 스트림 -> 출력 스트림
		FileCopyUtils.copy(is, os);
		is.close();
		os.flush();
		os.close();
		// TODO Auto-generated method stub
	}
}

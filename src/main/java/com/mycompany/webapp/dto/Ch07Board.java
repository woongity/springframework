package com.mycompany.webapp.dto;

import java.util.Date;

public class Ch07Board {
	private int no;
	private String content;
	private String title;
	private Date date;
	private String writer;
	
	public Ch07Board() {
	}

	public Ch07Board(int no, String content, String title, Date date, String writer) {
		this.no = no;
		this.content = content;
		this.title = title;
		this.date = date;
		this.writer = writer;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}

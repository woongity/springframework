package com.mycompany.webapp.dto;

import lombok.Data;

@Data
public class Ch14Member {
	private String mid;
	private String mpassword;
	private String mname;
	private int menabled;
	private String mrole;
}

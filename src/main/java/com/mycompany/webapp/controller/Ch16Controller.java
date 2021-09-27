package com.mycompany.webapp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.service.Ch16AccountService;

@Controller
@RequestMapping("/ch16")
public class Ch16Controller {
	@Resource private Ch16AccountService accountService;

}

package com.mycompany.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Ch11City;
import com.mycompany.webapp.dto.Ch11Member;
import com.mycompany.webapp.dto.Ch11Skill;

@Controller
@RequestMapping("/ch11")
public class Ch11Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);

	@RequestMapping("/content")
	public String content() {
		return "/ch11/content";
	}
	@PostMapping("/form1")
	public String handleForm1(Ch11Member member) {
		logger.info(member.getMname());
		return "redirect:/ch11/content";
	}
	
	// 기본값을 제공하기 위해서 사용
	@GetMapping("/form1")
	public String form1(@ModelAttribute("member") Ch11Member member) {
		member.setMnation("한국");
		return "/ch11/form1";
	}
	@RequestMapping("/form2")
	public String form2(@ModelAttribute("member") Ch11Member member,Model model) {
		logger.info("실행");
		List<String> typeList = new ArrayList<>();
		typeList.add("일반회원");
		typeList.add("기업회원");
		typeList.add("헤드헌터회원");
		model.addAttribute("typeList",typeList);
		// 기본선택 항목을 지정.
		member.setMtype("헤드헌터회원");
		List<String> jobList = new ArrayList<String>();
		jobList.add("학생");
		jobList.add("개발자");
		jobList.add("디자이너");
		model.addAttribute("jobList",jobList);
		//기본 선택항목 지정
		member.setMjob("개발자");
		
		List<Ch11City> cityList = new ArrayList<Ch11City>();
		cityList.add(new Ch11City(1,"서울"));
		cityList.add(new Ch11City(2,"부산"));
		cityList.add(new Ch11City(3,"인천"));
		model.addAttribute("cityList",cityList);
		
		member.setMcity(3);
		return "/ch11/form2";
	}
	@RequestMapping("/form3")
	public String form3(@ModelAttribute("member") Ch11Member member,Model model) {
		logger.info("form3 실행");
		List<String> languageList = new ArrayList<String>();
		languageList.add("C");
		languageList.add("java");
		languageList.add("python");
		languageList.add("javaScript");
		model.addAttribute("languageList",languageList);
		
		member.setMlanguage(new String[] {"java","python"});
		
		List<Ch11Skill> skillList = new ArrayList<>();
		skillList.add(new Ch11Skill(1,"Spring"));
		skillList.add(new Ch11Skill(2,"django"));
		skillList.add(new Ch11Skill(3,"vue"));
		model.addAttribute("skillList",skillList);
		
		// 기본값 지정
		member.setMskill(new String[]{"Spring","vue"});
		
		return "/ch11/form3";
	}
}

package com.huawangxin.web;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
// http://localhost:8080/spring4/demo
public class DemoController 
	implements Serializable {
	
	@RequestMapping("/hello.form")
//http://localhost:8080/spring4/demo/hello.form
	public String execute(){
		System.out.println("Hello"); 
		return "hello";// -> hello.jsp
	}
	
	@RequestMapping("/demo.form")
	// /spring6/demo/demo.form?e=ok
	public String demo(String e, ModelMap map){
		if(e==null || e.trim().equals("")){
			String s = null;
			s.charAt(0);
		}
		map.addAttribute("message", "“Ï≥£—› æ");
		return "success";
	}
}














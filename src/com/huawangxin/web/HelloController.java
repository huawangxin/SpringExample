package com.huawangxin.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
public class HelloController
	implements Controller, Serializable{
	public ModelAndView handleRequest(
			HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		System.out.println("Hello");
		Map<String, Object> data = 
			new HashMap<String, Object>();
		data.put("message", "Hello Spring!");
		//data ���͵�JSP������ʾ������
		//data�������Զ��󶨵�request�����attribute��
		return new ModelAndView("hello", data);
	}
}






package com.huawangxin.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huawangxin.entity.User;
import com.huawangxin.service.NameOrPwdException;
import com.huawangxin.service.UserService;

@Controller //不能忘记
@RequestMapping("/login2")
public class LoginController2{
	
	@Resource
	private UserService service;
	
	@ExceptionHandler
	//如果控制器方法出现异常, 会执行异常处理方法
	//异常处理方法的参数必须是 Request 和 Exception
	public String execute( HttpServletRequest req,
			Exception ex){
		System.out.println("Demo"); 
		if(ex instanceof NameOrPwdException){
			req.setAttribute("message", ex.getMessage());
			return "login";
		}
		return "error";
	}
	
	@RequestMapping("/login-action1.form")
	public String loginAction1(String name, 
			String pwd, 
			HttpServletRequest req) throws Exception{
		User user = service.login(name, pwd);
		req.getSession().setAttribute("loginUser", user);
		req.setAttribute("message", "登录成功!");
		return "success";
	}
	@RequestMapping("/login-action2.form")
	public String loginAction2(String name, 
			String pwd) throws Exception{
		User user = service.login(name, pwd);
		return "success";
	}
}

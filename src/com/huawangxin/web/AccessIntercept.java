package com.huawangxin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.huawangxin.entity.User;
/**
 * 认证拦截 
 */
public class AccessIntercept
	extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object handler) throws Exception {
		//如果登录了, 才能继续访问, 否则就重定向到
		//登录页面, 登录以后才能继续访问
		//String requestPath = request.getRequestURI();
		//if(requestPath.contains("/login")){
		//	return true;
		//}
		User loginUser = (User)request.getSession()
			.getAttribute("loginUser");
		if(loginUser==null){
			//如果没有登录 重定向到登录页面
			String path = request.getSession()
				.getServletContext().getContextPath();
			String login = path+"/login/login.form";
			response.sendRedirect(login);
			return false;
		}
		return true;
	}
}





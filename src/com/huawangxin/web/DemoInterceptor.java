package com.huawangxin.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor 
	implements HandlerInterceptor, Serializable {
	
	/** 在请求执行之前执行, 返回值为true, 执行后续
	 * 请求, 返回false, 就不再执行后续请求了 */
	public boolean preHandle(
			HttpServletRequest req,
			HttpServletResponse res, 
			Object handler) throws Exception {
		System.out.println("执行preHandler");
		return true;
	}
	/** 请求处理完毕(控制器执行完毕)执行这个方法 */
	public void postHandle(
			HttpServletRequest req,
			HttpServletResponse res, 
			Object handler, ModelAndView m) 
		throws Exception {
		System.out.println("postHandle");
	}
	/** 所以处理都结束以后执行 */
	public void afterCompletion(
			HttpServletRequest req,
			HttpServletResponse res, 
			Object handler, Exception e)throws Exception{
		System.out.println("afterCompletion");
	}

}

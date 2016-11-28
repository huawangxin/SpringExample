package com.huawangxin.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor 
	implements HandlerInterceptor, Serializable {
	
	/** ������ִ��֮ǰִ��, ����ֵΪtrue, ִ�к���
	 * ����, ����false, �Ͳ���ִ�к��������� */
	public boolean preHandle(
			HttpServletRequest req,
			HttpServletResponse res, 
			Object handler) throws Exception {
		System.out.println("ִ��preHandler");
		return true;
	}
	/** ���������(������ִ�����)ִ��������� */
	public void postHandle(
			HttpServletRequest req,
			HttpServletResponse res, 
			Object handler, ModelAndView m) 
		throws Exception {
		System.out.println("postHandle");
	}
	/** ���Դ��������Ժ�ִ�� */
	public void afterCompletion(
			HttpServletRequest req,
			HttpServletResponse res, 
			Object handler, Exception e)throws Exception{
		System.out.println("afterCompletion");
	}

}

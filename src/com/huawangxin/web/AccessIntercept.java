package com.huawangxin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.huawangxin.entity.User;
/**
 * ��֤���� 
 */
public class AccessIntercept
	extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object handler) throws Exception {
		//�����¼��, ���ܼ�������, ������ض���
		//��¼ҳ��, ��¼�Ժ���ܼ�������
		//String requestPath = request.getRequestURI();
		//if(requestPath.contains("/login")){
		//	return true;
		//}
		User loginUser = (User)request.getSession()
			.getAttribute("loginUser");
		if(loginUser==null){
			//���û�е�¼ �ض��򵽵�¼ҳ��
			String path = request.getSession()
				.getServletContext().getContextPath();
			String login = path+"/login/login.form";
			response.sendRedirect(login);
			return false;
		}
		return true;
	}
}





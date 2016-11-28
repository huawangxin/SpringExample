package com.huawangxin.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huawangxin.entity.User;
import com.huawangxin.service.NameOrPwdException;
import com.huawangxin.service.NullParamException;
import com.huawangxin.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController 
	implements Serializable{
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.form")
	//localhost:8080/spring4/login/login.form
	public String loginForm() throws Exception{
		return "login";//login.jsp
	}
	@RequestMapping("/login-action1.form")
	// /spting4/login/login-action1.form
	public String loginAction1(
			HttpServletRequest req) throws Exception{
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		System.out.println(name);
		System.out.println(pwd);	
		//��¼�����߼�
		try{
			User user = userService.login(name, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			req.setAttribute(
					"message", "��ӭ"+user.getName());
			return "success";
		}catch(NameOrPwdException e){
			e.printStackTrace();
			req.setAttribute("message1","���������");
			return "login";
		}catch (NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message1","���ܿգ�");
			return "login";
		}
	}
	
	@RequestMapping("/login-action2.form")
	public String loginAction2(
			//Spring MVC ����<input name="name"> ��ֵ
			//�Զ�ע�뵽��������name��
			String name, 
			@RequestParam("pwd") String password,
			HttpServletRequest req){
	//��¼�����߼�
		try{
			User user = userService.login(name,password);
			req.getSession().setAttribute(
					"loginUser", user);
			req.setAttribute(
					"message", "��ӭ"+user.getName());
			return "success";
		}catch(NameOrPwdException e){
			e.printStackTrace();
			req.setAttribute("message2","���������");
			return "login";
		}catch (NullParamException e) {
			e.printStackTrace();
			req.setAttribute("message2","���ܿգ�");
			return "login";
		}
	}
	
	@RequestMapping("/login-action3.form")
	public String loginAction3(User user,
			HttpServletRequest req){
		String name = user.getName();
		String pwd = user.getPwd();
		try{
			User u = userService.login(name, pwd);
			req.getSession().setAttribute("loginUser", u);
			req.setAttribute("message", "��ӭ����"+u.getName());
			return "success";
		}catch(NameOrPwdException e){
			e.printStackTrace();
			req.setAttribute(
					"message3",e.getMessage());
			return "login";
		}catch(NullParamException e){
			e.printStackTrace();
			req.setAttribute(
					"message3",e.getMessage());
			return "login";
		}
	}
	
	/** ����ʹ�� ModelAndView ����洫������ */
	@RequestMapping("/login-action4.form")
	public ModelAndView loginAction4(
			String name, String pwd, 
			HttpServletRequest req){
		Map<String, Object> data = 
			new HashMap<String, Object>();
		try{
			User user = userService.login(name, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			data.put("message",
					"��ӭ����!"+user.getName());
			//����ֵ��ʾʹ��success��ͼ��ʾdata����
			return new ModelAndView("success", data);
		}catch(NameOrPwdException e){
			e.printStackTrace();
			data.put("message4", "���������!");
 			return new ModelAndView("login", data);
		}catch(NullParamException e){
			e.printStackTrace();
			data.put("message4", "��˭��(@_@)?");
		 	return new ModelAndView("login", data);
		}
	}
	
	/** ʹ��ModuleMap ��JSP�������� */
	@RequestMapping("/login-action5.form")
	public String loginAction5(
			String name, String pwd, 
			ModelMap model, HttpServletRequest req){
		try{
			User user = userService.login(name, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			model.addAttribute("message", "��ӭ����!");
			return "success";
		}catch(NameOrPwdException e){
			e.printStackTrace();
			model.addAttribute(
					"message5", e.getMessage());
			return "login";
		}catch(NullParamException e){
			e.printStackTrace();
			model.addAttribute(
					"message5", e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping("/login-action6.form")
	public String loginAction6(
			//name��ҳ�洫�ݵ�ֵ, Ҳ�Ƿ��ص�ҳ���ֵ
			@ModelAttribute("name") String name, 
			String pwd, 
			ModelMap model,
			HttpServletRequest req){
		try{
			User user = userService.login(name, pwd);
			req.getSession().setAttribute(
					"loginUser", user);
			model.addAttribute("message", "��ӭ����!");
			return "success";
		}catch(NameOrPwdException e){
			e.printStackTrace();
			model.addAttribute(
					"message6", e.getMessage());
			return "login";
		}catch(NullParamException e){
			e.printStackTrace();
			model.addAttribute(
					"message6", e.getMessage());
			return "login";
		}
	}
	
	private String[] msg = {"�������������!",
			"����, ���������?", "����������Է�!"};
	@ModelAttribute("alert")
	//Spring ��ִ��getAlert()����, ������ֵ���ݵ�ҳ��
	//��ҳ���ϰ󶨵�������Ϊ "alert"
	public String getAlert(){
		Random r = new Random();
		int i = r.nextInt(msg.length);
		return msg[i];
	}
	
	
	/** �ض������:
	 * ���� hi.form �ض��� login.form */
	@RequestMapping("hi.form")
	public String hiAction(HttpServletRequest req){
		ServletContext ctx = 
			req.getSession().getServletContext();
		String path = ctx.getContextPath();
		// ctx.getContextPath() ��õ�ǰӦ�ó�����
		// req.getServerName() ��õ�ǰ���������
		// req.getServerPort() ��ȡ����Ķ˿ں� Ĭ��80
		System.out.println(path); 
		String p = "http://"+
							req.getServerName()+":"+
							req.getServerPort()+
							path + "/login/login.form";
		// "redirect:http://huawangxin.com.cn"
		//return "redirect:login.form";
		//System.out.println(p);
 		return "redirect:"+p;//
		//return "http://localhost:8088/" +
		//		"spring4/login/login.form";
	}
	
	@RequestMapping("login-action7.form")
	public String loginAction7(
			String name, 
			ModelMap model) throws Exception{
		StringBuilder buf = new StringBuilder();
		for(int i=0; i<name.length(); i++){
			char c = name.charAt(i);
			System.out.println(Integer.toHexString(c));
			buf.append(Integer.toHexString(c))
			.append(" ");
		}
		System.out.println(name);
		byte[] bytes = name.getBytes("iso8859-1");
		String n = new String(bytes, "utf-8");
		System.out.println(n); //��ȷ!
		model.addAttribute("message7", buf.toString());
		return "login";
	}
	
	@RequestMapping("/login-action8.form")
	public String loginAction8(String name){
		System.out.println(name);
		return "login";
	}
}
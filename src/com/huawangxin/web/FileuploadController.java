package com.huawangxin.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileuploadController {
	
	@RequestMapping("/form.form")
	//��ʾ���ر�
	public String form(){
		return "fileupload";
	}
	
	@ExceptionHandler
	public String execute(HttpServletRequest req,
			Exception e){
		if(e instanceof MaxUploadSizeExceededException){
			req.setAttribute("message", "̫����");
			return "fileupload";
		}
		return "error";
	}
	
	@RequestMapping("/upload.form")
	//������������
	public String upload(
			@RequestParam(value="image", required=true)
			MultipartFile image,
			String location, ModelMap map,
			HttpServletRequest req) 
		throws Exception {
		//�����ļ��Ĺ���
		String filename = image.getOriginalFilename();
		InputStream in = image.getInputStream();
		//����������ÿ��byteд���������, �Ϳ�������ļ�
		//�ı��湤��
		String path = "/WEB-INF/images";
		//��Web·��ӳ�䵽��ǰ�ļ�ϵͳ��·��
		ServletContext ctx = 
			req.getSession().getServletContext();
		path = ctx.getRealPath(path);
		File dir = new File(path);
		if(!dir.exists()){dir.mkdir();}
		FileOutputStream out =new FileOutputStream(new File(dir,location+"_"+filename));
		StreamUtils.copy(in, out);
		in.close();
		out.close();
		map.addAttribute("message","������"+filename);
		return "success";
	}
}
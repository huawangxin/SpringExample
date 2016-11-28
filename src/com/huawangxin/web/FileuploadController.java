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
	//显示上载表单
	public String form(){
		return "fileupload";
	}
	
	@ExceptionHandler
	public String execute(HttpServletRequest req,
			Exception e){
		if(e instanceof MaxUploadSizeExceededException){
			req.setAttribute("message", "太大了");
			return "fileupload";
		}
		return "error";
	}
	
	@RequestMapping("/upload.form")
	//处理上载请求
	public String upload(
			@RequestParam(value="image", required=true)
			MultipartFile image,
			String location, ModelMap map,
			HttpServletRequest req) 
		throws Exception {
		//保存文件的过程
		String filename = image.getOriginalFilename();
		InputStream in = image.getInputStream();
		//将输入流的每个byte写出到输出流, 就可以完成文件
		//的保存工作
		String path = "/WEB-INF/images";
		//将Web路径映射到当前文件系统的路径
		ServletContext ctx = 
			req.getSession().getServletContext();
		path = ctx.getRealPath(path);
		File dir = new File(path);
		if(!dir.exists()){dir.mkdir();}
		FileOutputStream out =new FileOutputStream(new File(dir,location+"_"+filename));
		StreamUtils.copy(in, out);
		in.close();
		out.close();
		map.addAttribute("message","上载了"+filename);
		return "success";
	}
}
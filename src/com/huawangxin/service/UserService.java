package com.huawangxin.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huawangxin.dao.UserDao;
import com.huawangxin.entity.User;

/** 业务层 注解  */
@Service //默认的Bean ID是 userService
public class UserService implements Serializable {

	private UserDao userDao;
 
	//@Resource //自动匹配userDao对象并注入
	@Resource(name="userDao")
	public void setUserDao( UserDao userDao) {
		this.userDao = userDao;//
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	/** 登录系统功能 */
	public User login(String name, String pwd) 
		throws NameOrPwdException, NullParamException{
		if(name == null || name.equals("") || 
			pwd==null || pwd.equals("")){
			throw new NullParamException("登录参数不能为空！");
		}
		User user = userDao.findByName(name);
		if(user != null && pwd.equals(user.getPwd())){
			return user;
		}
		throw new NameOrPwdException("用户名或者密码错误");
	}
}

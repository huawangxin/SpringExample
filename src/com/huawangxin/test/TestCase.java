package com.huawangxin.test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.huawangxin.dao.EmpDao;
import com.huawangxin.entity.Emp;
import com.huawangxin.entity.User;
import com.huawangxin.service.UserService;
import com.huawangxin.web.DemoInterceptor;


public class TestCase {
	//@Test
	public void testLogin() throws Exception{
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		UserService s = ctx.getBean(
				"userService", UserService.class);
		User  u = s.login("Tom", "123");
		System.out.println(u); 
	}
	
	//@Test
	public void testDemo() throws Exception{
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		DemoInterceptor demo = ctx.getBean(
				"demo", DemoInterceptor.class);
		System.out.println(demo); 
	}
	
//	@Test
	public void testDbcp() throws Exception{
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		//DataSource 是 DriverManager 的二代
		DataSource ds = ctx.getBean(
				"dbcpDataSource", DataSource.class);
		System.out.println(ds);
		Connection conn = ds.getConnection();
		System.out.println(conn);
		System.out.println(conn.getMetaData()
				.getDatabaseProductName());
		conn.close();
	}
	
//	@Test
	public void testJdbcTemplate() throws Exception{
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(cfg);
		JdbcTemplate jdbcTemplate = ctx.getBean(
				"jdbcTemplate", JdbcTemplate.class);
		System.out.println(jdbcTemplate);
		String sql = "select 1 as id from dual";
		Integer id = jdbcTemplate.queryForObject(
				sql, Integer.class);
		System.out.println(id); 
	}
//	@Test
	public void testAddEmp() throws Exception{
		String cfg="spring-mvc.xml";
		ApplicationContext ctx=new ClassPathXmlApplicationContext(cfg);
		EmpDao dao=ctx.getBean("empDao",EmpDao.class);
		Emp e = new Emp("Tom2", null, 
				new Date(System.currentTimeMillis()),
				2322.55, null, 1);
		dao.add(e);
		System.out.println(e);
	}
	@Test
	public void testFindAll() throws Exception{
		String cfg="spring-mvc.xml";
		ApplicationContext ctx=new ClassPathXmlApplicationContext(cfg);
		EmpDao dao=ctx.getBean("empDao",EmpDao.class);
		List<Emp> all=dao.findAll();
		System.out.println(all);
	}
}
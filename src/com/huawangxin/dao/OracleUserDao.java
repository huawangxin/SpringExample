package com.huawangxin.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.huawangxin.entity.User;
 
/** 持久层 注解  */
@Repository("userDao") //指定特定的Bean ID 方便setUserDao注入
public class OracleUserDao implements UserDao, Serializable{
	
	private JdbcDataSource dataSource;
	
	public OracleUserDao() {
	}

	/** 创建 OracleUserDAO 对象必须依赖于JDBCDataSource实例 */
	public OracleUserDao(JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Autowired //按照类型自动装配
	public void setDataSource(
			@Qualifier("jdbcDataSource")  JdbcDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public JdbcDataSource getDataSource() {
		return dataSource;
	}
	
	/** 根据唯一用户名查询系统用户, 如果没有找到用户信息返回null */
	public User findByName(String name) {
		System.out.println("利用JDBC技术查找User信息");
		String sql = "select id, name, pwd, phone  from USERS where name=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			User user=null;
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setPhone(rs.getString("phone"));
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
}

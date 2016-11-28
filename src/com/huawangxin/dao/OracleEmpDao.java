package com.huawangxin.dao;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.huawangxin.entity.Emp;

@Repository("empDao")
public class OracleEmpDao 
	implements EmpDao, Serializable{
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	private class EmpMapper implements RowMapper<Emp>{
		//map映射 Row 行，数据行和对象属性的映射关系
		public Emp mapRow(ResultSet rs, int index) throws SQLException {
			//将当前ResultSet中的一行映射到一个Emp对象属性
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setMgr(rs.getInt("mgr"));
			emp.setHiredate(rs.getDate("hiredate"));
			emp.setSal(rs.getDouble("sal"));
			emp.setComm(rs.getDouble("comm"));
			emp.setDeptno(rs.getInt("deptno"));
			return emp;
		}
	}

	public void add(Emp emp) {
		//获取自动员工编号
		String sql="select SEQ_T_EMP.nextval "+"from dual";
		Integer empno=jdbcTemplate.queryForObject(sql, Integer.class);
		emp.setEmpno(empno);
		sql="insert into t_emp_wangxin1 (empno,ename,mgr,hiredate,sal,comm,deptno) " +
				"values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,emp.getEmpno(),emp.getEname(),emp.getMgr()
				,emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno());
		
	}

	public Emp add(String ename, Integer mgr, Date hiredate, Double sal,
			Double comm, Integer deptno) {
		//获取自动员工编号 empno
		String sql = "select SEQ_T_EMP.nextval " +
				"from dual";
		Integer empno = jdbcTemplate.queryForObject(
				sql,Integer.class);
		sql = "insert into t_emp_wangxin1 (empno, ename, " +
				"mgr, hiredate, sal, comm, deptno) " +
				"values (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,empno,
				ename, mgr,
				hiredate, sal,
				comm, deptno);
		Emp emp = new Emp(ename, mgr, hiredate, sal, comm, deptno);
		emp.setEmpno(empno);
		return emp;
	}

	public Emp delete(Integer empno) {
		String sql = "select empno,ename,mgr,hirdate,sal,comm,deptno from t_emp where empno=?";
		try{
			Emp emp = jdbcTemplate.queryForObject(
				sql, new EmpMapper(), empno);
			sql = "delete from t_emp where empno=?";
			jdbcTemplate.update(sql, empno);
			return emp;
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void delete(Emp emp) {
		String sql = "delete from t_emp where empno=?";
		jdbcTemplate.update(sql, emp.getEmpno());
	}

	public List<Emp> findAll() {
		String sql = "select empno,ename,mgr,hiredate,sal,comm,deptno from t_emp_wangxin1";
		List<Emp> all = jdbcTemplate.query(
				sql, new EmpMapper());
		return all;
	}
	public Emp findById(Integer empno) {
		String sql = "select * from t_emp where empno=?";
		try{
			Emp emp = jdbcTemplate.queryForObject(
				sql, new EmpMapper(), empno);
			return emp;
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void update(Emp emp) {
		//你来写吧, 参考 insert
		
	}
	
}

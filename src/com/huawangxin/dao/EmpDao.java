package com.huawangxin.dao;

import java.sql.Date;
import java.util.List;

import com.huawangxin.entity.Emp;

public interface EmpDao {
	void add(Emp emp);
	Emp add(String ename, Integer mgr, 
			Date hiredate, Double sal, Double comm,
			Integer deptno);
	//remove
	Emp delete(Integer empno);
	void delete(Emp emp);
	void update(Emp emp);
	Emp findById(Integer empno);
	List<Emp> findAll();
}





select empno,ename,mgr,hiredate,sal,comm,deptno from t_emp_wangxin1
-- Create Schema By Sys as DBA
-- USER SQL
-- CREATE USER openlab IDENTIFIED BY open123 ;

-- ROLES
-- GRANT "CONNECT" TO openlab ;
-- GRANT "RESOURCE" TO openlab ;

-- drop table users;
CREATE TABLE T_USER 
(
  ID NUMBER(7, 0) , 
  NAME VARCHAR2(50) , 
  PWD VARCHAR2(50), 
  PHONE VARCHAR2(50) ,
  PRIMARY KEY (id),
  constraint t_user_name_unique unique(name)
);
--drop SEQUENCE SEQ_T_USER;
CREATE SEQUENCE SEQ_T_USER;
insert into T_User (id, name, pwd, phone) 
   values (SEQ_T_USER.nextval,'Tom','123','110');
insert into T_User (id, name, pwd, phone) 
   values (SEQ_T_USER.nextval,'Jerry','abc','119');
insert into T_User (id, name, pwd, phone) 
   values (SEQ_T_USER.nextval,'Andy','456','112');

-- drop table t_emp;
CREATE TABLE t_emp_wangxin1 
(
  empno NUMBER(7, 0) , 
  ename VARCHAR2(50) ,
  mgr NUMBER(7, 0),  
  hiredate DATE, 
  sal NUMBER(7, 2),
  comm NUMBER(7, 2),
  deptno NUMBER(7, 0),
  PRIMARY KEY (empno)
);
--drop SEQUENCE SEQ_T_EMP;
CREATE SEQUENCE SEQ_T_EMP;   

   
   
   
   
   
   
   